package pack1;

import static org.lwjgl.opengl.GL11.*;

public class Player extends Tank
{
    private int input_shoot;


    public Player(int x, int y)
    {
        super(x, y);
        this.set_input_shoot(1);
    }
    public void set_input(int input)// dla glutSpecialFunc
    {
        switch (input)
        {
            case 1:
            {
                super.set_delta(4);
                this.set_input_shoot(4);
                break;
            }
            case 2:
            {
                super.set_delta(2);
                this.set_input_shoot(2);
                break;
            }
            case 3:
            {
                super.set_delta(3);
                this.set_input_shoot(3);
                break;
            }
            case 4:
            {
                super.set_delta(1);
                this.set_input_shoot(1);
                break;
            }
            case -1:	super.set_delta(0); break;
        }

    }

    public void set_input_shoot(int input)
    {
        this.input_shoot = input;
    }

    public int get_input_shoot()
    {
        return this.input_shoot;
    }

    public void draw_player()
    {
        MyDisplay.keyboard(get_x(),get_y());
        if(Map.check_wall(get_x(), get_y(), get_delta(), get_size()) == get_delta()
            || MyDisplay.checkFunc2(get_x(), get_y(), get_delta(), get_size()) == get_delta())
        {
            set_delta(0);
        }
        super.controls();
        switch (get_input_shoot())
        {
            case 1:
            {   //UP
                glBegin(GL_QUADS);

                glTexCoord2f(0, 1);
                glVertex2f(get_x() - get_size(), get_y() - get_size());
                glTexCoord2f(1, 1);
                glVertex2f(get_x() + get_size(), get_y() - get_size());
                glTexCoord2f(1, 0);
                glVertex2f(get_x() + get_size(), get_y() + get_size());
                glTexCoord2f(0, 0);
                glVertex2f(get_x() - get_size(), get_y() + get_size());
                glEnd();
                break;
            }
            case 3:
            {	//LEFT
                glBegin(GL_QUADS);
                glTexCoord2f(1, 1);
                glVertex2f(get_x() - get_size(), get_y() - get_size());
                glTexCoord2f(1, 0);
                glVertex2f(get_x() + get_size(), get_y() - get_size());
                glTexCoord2f(0, 0);
                glVertex2f(get_x() + get_size(), get_y() + get_size());
                glTexCoord2f(0, 1);
                glVertex2f(get_x() - get_size(), get_y() + get_size());
                glEnd();

                break;
            }
            case 2:
            {	//RIGHT
                glBegin(GL_QUADS);
                glTexCoord2f(0, 0);
                glVertex2f(get_x() - get_size(), get_y() - get_size());
                glTexCoord2f(0, 1);
                glVertex2f(get_x() + get_size(), get_y() - get_size());
                glTexCoord2f(1, 1);
                glVertex2f(get_x() + get_size(), get_y() + get_size());
                glTexCoord2f(1, 0);
                glVertex2f(get_x() - get_size(), get_y() + get_size());
                glEnd();

                break;
            }
            case 4:
            {	//DOWN
                glBegin(GL_QUADS);
                glTexCoord2f(1, 0);
                glVertex2f(get_x() - get_size(), get_y() - get_size());
                glTexCoord2f(0, 0);
                glVertex2f(get_x() + get_size(), get_y() - get_size());
                glTexCoord2f(0, 1);
                glVertex2f(get_x() + get_size(), get_y() + get_size());
                glTexCoord2f(1, 1);
                glVertex2f(get_x() - get_size(), get_y() + get_size());
                glEnd();

                break;
            }
        }
        glDisable(GL_TEXTURE_2D);


    }
}
