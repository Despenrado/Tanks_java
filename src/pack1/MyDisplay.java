package pack1;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

public class MyDisplay
{
    private static int change_display = 0;
    private static int old_display = 0;
    private static int a = 0;

    public static int checkFunc2(int x1, int y1, int delta1, int size)
    {
        switch (change_display)
        {
            case 1:
            {
                return Single.check_player_single(x1, y1, delta1, size);
            }
            case 2:
            {
                return Multi.check_player_multi(x1, y1, delta1, size);
            }
        }
        return 0;
    }

    public static int checkFunc3(int x1, int y1, int delta1, int size, int n)
    {
        switch (change_display)
        {
            case 1:
            {
                return Single.check_bullet_single(x1, y1, delta1, size, n);
            }
            case 2:
            {
                return Multi.check_bullet_multi(x1, y1, delta1, size, n);
            }
        }
        return 0;
    }

    public static int get_change_display()
    {
        return change_display;
    }

    public static void set_change_display(int n)
    {
        change_display = n;
    }

    public static void mouse_button()
    {
        if (a == 0)
        {
            if(Mouse.isButtonDown(0))
            {

                switch (change_display)
                {
                    case 0:
                        {
                        if (600 - Mouse.getY() < 200 && 600 - Mouse.getY() > 175 && Mouse.getX() < 550 && Mouse.getX() > 250) {
                            Single.stats_on_0_single();
                            old_display = 1;
                            set_change_display(1);
                        }
                        if (600 - Mouse.getY() < 325 && 600 - Mouse.getY() > 300 && Mouse.getX() < 525 && Mouse.getX() > 275) {
                            Multi.stats_on_0_multi();
                            old_display = 2;
                            set_change_display(2);
                        }
                        if (600 - Mouse.getY() < 450 && 600 - Mouse.getY() > 425 && Mouse.getX() < 450 && Mouse.getX() > 350) {
                            System.exit(0);
                        }
                        break;
                    }
                    case 3: {
                        a = 1;
                        if (600 - Mouse.getY() < 200 && 600 - Mouse.getY() > 175 && Mouse.getX() < 562 && Mouse.getX() > 237) {
                            change_display = old_display;
                        }
                        if (600 - Mouse.getY() < 450 && 600 - Mouse.getY() > 425 && Mouse.getX() < 637 && Mouse.getX() > 187) {
                            switch (old_display) {
                                case 1:
                                    Single.Clear_Objects_single();
                                    break;
                                case 2:
                                    Multi.Clear_Objects_multi();
                                    break;
                            }
                            set_change_display(0);
                        }
                        break;
                    }
                    case 4: {
                        if (600 - Mouse.getY() < 425 && 600 - Mouse.getY() > 400 && Mouse.getX() < 637 && Mouse.getX() > 187) {
                            Single.Clear_Objects_single();
                            set_change_display(0);
                        }
                        break;
                    }
                    case 5: {
                        if (600 - Mouse.getY() < 425 && 600 - Mouse.getY() > 400 && Mouse.getX() < 637 && Mouse.getX() > 187) {
                            Single.Clear_Objects_single();

                            set_change_display(0);
                        }
                        break;
                    }
                    case 6: {
                        if (600 - Mouse.getY() < 425 && 600 - Mouse.getY() > 400 && Mouse.getX() < 637 && Mouse.getX() > 187) {
                            Multi.Clear_Objects_multi();
                            set_change_display(0);
                        }
                        break;
                    }
                    case 7: {
                        if (600 - Mouse.getY() < 425 && 600 - Mouse.getY() > 400 && Mouse.getX() < 637 && Mouse.getX() > 187) {
                            Multi.Clear_Objects_multi();
                            set_change_display(0);
                        }
                        break;
                    }
                }
            }
        }
        if(a > 0)
        {
            a++;
        }
        if(a == 60)
        {
            a = 0;
        }

    }

    public static void keyboard(int x,int y)
    {
        if (change_display == 1)
        {
            Single.keyboard_player_single();
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
            {
                change_display = 3;
            }
        }
        if (change_display == 2)
        {
            Multi.keyboard_player_multi(x, y);
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
            {
                change_display = 3;
            }
        }
    }
    public static void display()
    {

        switch (change_display)
        {
            case 0:
            {
                Image.draw_menu();
                break;
            }
            case 1:
            {
                Map.draw_pix();
                Single.show_single_player();

                break;
            }
            case 2:
            {
                Map.draw_pix();
                Multi.show_multi_player();

                break;
            }
            case 3:
            {
                Image.draw_pause();
                break;
            }
            case 4://win
            {
                Image.draw_you_win();
                break;
            }
            case 5://lose
            {
                Image.draw_game_over();
                break;
            }
            case 6://win1
            {
                Image.draw_player2_win();
                break;
            }
            case 7://win2
            {
                Image.draw_player1_win();
                break;
            }
        }

    }

    public static void ticks()
    {
        while(!Display.isCloseRequested())
        {
            MyDisplay.mouse_button();
            glClear(GL_COLOR_BUFFER_BIT);
            MyDisplay.display();
            Display.update();
            Display.sync(60);
        }
    }



}
