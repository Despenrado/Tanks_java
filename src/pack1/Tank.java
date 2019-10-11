package pack1;

public class Tank
{
    private int x;             // COORDINATE OX
    private int y;             // COORDINATE OY
    private int size;		   // SIZE_OF_TANK/2
    private int delta;		   // DIRECTION OF THE OF MOVEMENT
    private int delta_shoot;   // USE IN SHOOTS

    public Tank(int x, int y)
    {
        this.set_x(x);
        this.set_y(y);
        this.set_size();
        this.set_delta(0);
        this.set_delta_shoot(1);
    }
    ////////////////////////////////////////////////////////////////////          SETTERS          ////////////////////////////////////////

    public void set_x(int x)
    {
        this.x = x;
    }

    public void set_y(int y)
    {
        this.y = y;
    }

    public void set_size()
    {
        this.size = 25;
    }

    public void set_delta(int delta)
    {
        this.delta = delta;
    }

    public void set_delta_shoot(int delta)
    {
        this.delta_shoot = delta;
    }

    public int get_x()
    {
        return this.x;
    }

    public int get_y()
    {
        return this.y;
    }

    public int get_size()
    {
        return this.size;
    }

    public int get_delta()
    {
        return this.delta;
    }

    public int get_delta_shoot()
    {
        return this.delta_shoot;
    }

    public void controls()
    {

        switch (get_delta())
        {
            case 1:
            {

                set_y(get_y() + 2);
                break;
            }
            case 2:
            {

                set_x(get_x() - 2);
                break;
            }
            case 3:
            {
                set_x(get_x() + 2);

                break;
            }
            case 4:
            {
                set_y(get_y() - 2);
                break;
            }
            default:
            {
                set_x(get_x());
                set_y(get_y());
            }
        }
    }
}
