package pack1;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class Multi
{
    static ArrayList<Player> player1;
    static ArrayList<Player> player2;
    static ArrayList<Bullet> bullet_pl1;
    static ArrayList<Bullet> bullet_pl2;

    public static int check_bullet_multi(int x1, int y1, int delta1, int size, int n)
    {
        switch (n)
        {
            case 3:
            {
                return Map.check_tank(x1, y1, delta1, size, player2.get(0).get_x(), player2.get(0).get_y());
            }
            case 4:
            {
                return Map.check_tank(x1, y1, delta1, size, player1.get(0).get_x(), player1.get(0).get_y());
            }
        }

        return 0;
    }

    public static int check_player_multi(int x1, int y1, int delta1, int size)
    {
        if (x1 == player1.get(0).get_x()&& y1 == player1.get(0).get_y())
        {
            int a = Map.check_tank(x1, y1, delta1, size, player2.get(0).get_x(), player2.get(0).get_y());
            if (a == player1.get(0).get_delta())
            {
                return a;
            }
        }
        if (x1 == player2.get(0).get_x()&& y1 == player2.get(0).get_y())
        {
            int a = Map.check_tank(x1, y1, delta1, size, player1.get(0).get_x(), player1.get(0).get_y());
            if (a == player2.get(0).get_delta())
            {
                return a;
            }
        }
        return 0;
    }

    private static void shoot1()
    {
        bullet_pl1.add(new Bullet(player1.get(0).get_x(), player1.get(0).get_y(), player1.get(0).get_input_shoot(), 3));
    }



    private static void shoot2()
    {
        bullet_pl2.add(new Bullet(player2.get(0).get_x(), player2.get(0).get_y(), player2.get(0).get_input_shoot(), 4));
    }

    private static void bullet_draw()
    {
        for(int ib = 0; ib < bullet_pl1.size(); ib++)
        {
            bullet_pl1.get(ib).draw_bullet();
        }
        for(int ib = 0; ib < bullet_pl2.size(); ib++)
        {
            bullet_pl2.get(ib).draw_bullet();
        }
    }

    public static void show_multi_player()
    {
        bullet_draw();
        Image.bind_tank();
        player1.get(0).draw_player();
        Image.bind_tank_bot();
        player2.get(0).draw_player();
        player1.get(0).set_input(-1);
        player2.get(0).set_input(-1);
    }

    public static void keyboard_player_multi(int x, int y)
    {
        if(x == player1.get(0).get_x() && y == player1.get(0).get_y())
        {
            if(Keyboard.isKeyDown(Keyboard.KEY_SLASH))
            {
                shoot1();
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_UP))
            {
                player1.get(0).set_input(1);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
            {
                player1.get(0).set_input(2);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
            {
                player1.get(0).set_input(3);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
            {
                player1.get(0).set_input(4);
            }
        }
        if(x == player2.get(0).get_x() && y == player2.get(0).get_y())
        {
            if(Keyboard.isKeyDown(Keyboard.KEY_C))
            {
                shoot2();
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_W))
            {
                player2.get(0).set_input(1);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_A))
            {
                player2.get(0).set_input(2);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_D))
            {
                player2.get(0).set_input(3);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_S))
            {
                player2.get(0).set_input(4);
            }
        }
    }



    public static void stats_on_0_multi()
    {
        player1 = new ArrayList<Player>();
        player1.add(new Player(500, 400));
        player2 = new ArrayList<Player>();
        player2.add(new Player(200, 200));
        bullet_pl1 = new ArrayList<Bullet>();
        bullet_pl2 = new ArrayList<Bullet>();
    }



    public static void Clear_Objects_multi()
    {
        player1.clear();
        player2.clear();
        bullet_pl1.clear();
        bullet_pl2.clear();
    }
}
