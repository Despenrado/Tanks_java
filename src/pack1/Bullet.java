package pack1;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
public class Bullet
{
    private int x;
    private int y;
    private int delta;
    private int size;
    private int n;

    public Bullet(int x, int y, int delta, int n)
            {
        this.x = x;
        this.y = y;
        this.delta = delta;
        set_size();
        this.n = n;
    }
    public void set_x(int x)
    {
        this.x = x;
    }

    public void set_y(int y)
    {
        this.y = y;
    }

    public void set_delta(int delta)
    {
        this.delta = delta;
    }

    public void set_size()
    {
        this.size = 5;
    }

    public void set_n(int n)
    {
        this.n = n;
    }

    public int get_y()
    {
        return this.y;
    }

    public int get_delta()
    {
        return this.delta;
    }

    public int get_x()
    {
        return this.x;
    }

    public int get_size()
    {
        return this.size;
    }

    public int get_n()
    {
        return this.n;
    }

    public void contrls()
{
    switch (get_delta())
    {
        case 1:
        {
            set_y(get_y() + 4);
            break;
        }
        case 2:
        {
            set_x(get_x() - 4);
            break;
        }
        case 3:
        {
            set_x(get_x() + 4);
            break;
        }
        case 4:
        {
            set_y(get_y() - 4);
            break;
        }
    }
}

    public void draw_bullet()
    {
        int a = MyDisplay.checkFunc3(get_x(), get_y(), get_delta(), get_size(), get_n());
        if (Map.check_wall(this.get_x(), this.get_y(), this.get_delta(), this.get_size()) == this.get_delta()
            || a == get_delta())
        {
            if (a == get_delta())
            {
                switch (n)
                {
                    case 1:
                    {
                        if (Single.get_bots() == 0)
                        {
                            MyDisplay.set_change_display(4);
                        }
                        Single.bullet_pl.remove(Single.bullet_pl.indexOf(this));
                        break;
                    }
                    case 2:
                    {
                        MyDisplay.set_change_display(5);
                        break;
                    }
                    case 3:
                    {
                        MyDisplay.set_change_display(6);
                        break;
                    }
                    case 4:
                    {
                        MyDisplay.set_change_display(7);
                        break;
                    }
                }
            }
            else
            {
                switch(MyDisplay.get_change_display())
                {
                    case 1:
                    {
                        if(Single.bullet_pl.indexOf(this) >= 0)
                        {
                            Single.bullet_pl.remove(Single.bullet_pl.indexOf(this));
                        }
                        else
                        {
                            for(int i = 0; i< 3; i++)
                            {
                                if(Single.bullet_bot.get(i).indexOf(this) >= 0 )
                                {
                                    Single.bullet_bot.get(i).remove(Single.bullet_bot.get(i).indexOf(this));
                                }
                            }
                        }
                        break;
                    }
                    case 2:
                    {

                        if(Multi.bullet_pl1.indexOf(this) >= 0 )
                        {
                            Multi.bullet_pl1.remove(Multi.bullet_pl1.indexOf(this));
                        }
                        else
                        {
                            if(Multi.bullet_pl2.indexOf(this) >= 0 )
                            {
                                Multi.bullet_pl2.remove(Multi.bullet_pl2.indexOf(this));
                            }
                        }
                        break;
                    }
                }
            }

        }
        else
        {
                contrls();
                Image.bind_bullet();


            glBegin(GL11.GL_QUADS);
            glTexCoord2f(0,0);
            glVertex2f(get_x() - get_size(), get_y() - get_size());
            glTexCoord2f(1,0);
            glVertex2f(get_x() + get_size(), get_y() - get_size());
            glTexCoord2f(1,1);
            glVertex2f(get_x() + get_size(), get_y() + get_size());
            glTexCoord2f(0,1);
            glVertex2f(get_x() - get_size(), get_y() + get_size());
            glEnd();
            glDisable(GL_TEXTURE_2D);
        }
    }
}
