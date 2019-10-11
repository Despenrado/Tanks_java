package pack1;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class Single
{
    static ArrayList<Player> player;
    static ArrayList<Bot> bot;
    static ArrayList<Bullet> bullet_pl;
    static ArrayList<ArrayList<Bullet>> bullet_bot = new ArrayList<>();;
    static int shoot_timer[] = new int[3];
    private static int bots = 3;

    public static int get_bots()
    {
        return bots;
    }

    public static int check_bullet_single(int x1, int y1, int delta1, int size, int n)
    {
        switch (n)
        {
            case 2:
            {
                return Map.check_tank(x1, y1, delta1, size, player.get(0).get_x(), player.get(0).get_y());
            }
            case 1:
            {
                for (int i3 = 0; i3 < bots; i3++)
                {
                    int a = Map.check_tank(x1, y1, delta1, size, bot.get(i3).get_x(), bot.get(i3).get_y());
                    if (a == delta1)
                    {
                        bots--;
                        bot.remove(i3);
                        return a;
                    }
                }
            }
        }
        return 0;
    }

    public static int check_player_single(int x1, int y1, int delta1, int size)
    {
        if (x1 == player.get(0).get_x() && y1 == player.get(0).get_y())
        {
            for (int i3 = 0; i3 < bots; i3++)
            {
                int a = Map.check_tank(x1, y1, delta1, size, bot.get(i3).get_x(), bot.get(i3).get_y());
                if (a == player.get(0).get_delta())
                {
                    return a;
                }
            }
        }
        else
        {
            for (int i3 = 0; i3 < bots; i3++)
            {
                if (x1 != bot.get(i3).get_x() && y1 != bot.get(i3).get_y())
                {
                    int a = Map.check_tank(x1, y1, delta1, size, bot.get(i3).get_x(), bot.get(i3).get_y());
                    if (a == delta1)
                    {
                        return a;
                    }
                }
            }
            int a = Map.check_tank(x1, y1, delta1, size, player.get(0).get_x(), player.get(0).get_y());
            if (a == delta1)
            {
                return a;
            }
        }
        return 0;
    }

    private static void shoot()
    {
        bullet_pl.add(new Bullet(player.get(0).get_x(), player.get(0).get_y(), player.get(0).get_input_shoot(), 1));
    }

    public static void draw_bullet_player()
    {
        for(int i = 0; i < bullet_pl.size(); i++)
        {
            bullet_pl.get(i).draw_bullet();
        }
    }

    public static void draw_bullet_bot(int nr)
    {
        shoot_timer[nr]++;
        if(shoot_timer[nr] % bot.get(nr).get_timer() == 0)
        bullet_bot.get(nr).add(new Bullet(bot.get(nr).get_x(), bot.get(nr).get_y(), bot.get(nr).get_delta(), 2));
        for(int i = 0; i < bullet_bot.get(nr).size(); i++)
        {
            bullet_bot.get(nr).get(i).draw_bullet();
        }
        if ((int)(Math.random() * 10000)%128 == 3)
        {
            bot.get(nr).set_input();
        }
    }

    public static void show_single_player()
    {
        draw_bullet_player();
        for (int i3 = 0; i3 < bots; i3++)
        {
            draw_bullet_bot(i3);
        }
        Image.bind_tank();
        player.get(0).draw_player();
        for (int i4 = 0; i4 < bot.size(); i4++)
        {

            bot.get(i4).draw_bot();
        }
        player.get(0).set_input(-1);
    }

    public static void  keyboard_player_single()
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_SLASH) || Keyboard.isKeyDown(Keyboard.KEY_C))
        {
            shoot();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W))
        {
            player.get(0).set_input(1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A))
        {
            player.get(0).set_input(2);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D))
        {
            player.get(0).set_input(3);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S))
        {
            player.get(0).set_input(4);
        }
    }

    public static void stats_on_0_single()
    {
        player = new ArrayList<Player>();
        player.add(new Player(500, 400));
        bullet_pl = new ArrayList<Bullet>();
        bot = new ArrayList<Bot>();
        bot.add(new Bot(70,200,200));
        bot.add(new Bot(30, 500, 200));
        bot.add(new Bot(50, 500, 500));
        ArrayList<Bullet> b1 = new ArrayList<>();
        ArrayList<Bullet> b2 = new ArrayList<>();
        ArrayList<Bullet> b3 = new ArrayList<>();
        bullet_bot.add(b1);
        bullet_bot.add(b2);
        bullet_bot.add(b3);
        bots = 3;
        for(int i = 0; i < 3; i++)
        {
            shoot_timer[i] = 0;
        }
    }

    public static void Clear_Objects_single()
    {
        player.clear();
        bot.clear();
        bullet_pl.clear();
        bullet_bot.clear();
    }
}
