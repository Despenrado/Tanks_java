package pack1;
import static org.lwjgl.opengl.GL11.*;
public class Bot extends Tank
{
    private int timer;

    public Bot(int timer, int x, int y)
    {
        super(x, y);
        this.timer = timer;
        this.set_input();
    }

    public int get_timer()
    {
        return this.timer;
    }

    public void set_input()
    {
        super.set_delta((int)(Math.random() * 4) + 1);
    }

    public void draw_bot()
    {
        if(Map.check_wall(get_x(), get_y(), get_delta(), get_size()) == get_delta()
            || MyDisplay.checkFunc2(get_x(), get_y(), get_delta(), get_size()) == get_delta())
        {
            set_input();
        }
        else
        {
            controls();
        }
        Image.bind_tank_bot();
        switch (get_delta())
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
