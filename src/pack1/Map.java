package pack1;

public class Map
{
    static int wall[][] = new int[601][801];

    public static void set_wall()
    {
        for (int i = 0; i < 601; i++)
        {
            for (int i2 = 100; i2 < 701; i2++)
            {
                wall[i][i2] = 0;
            }
        }

        for (int i = 0; i < 800; i++)
        {
            wall[1][i] = 1;
            wall[2][i] = 1;
            wall[3][i] = 1;
            wall[4][i] = 1;
            wall[5][i] = 1;
            wall[6][i] = 1;

            wall[596][i] = 1;
            wall[597][i] = 1;
            wall[598][i] = 1;
            wall[599][i] = 1;
            wall[600][i] = 1;
        }

        for (int i = 250; i < 351; i++)
        {
            for (int i2 = 200; i2 < 601; i2++)
            {
                wall[i][i2] = 1;
            }
        }

        for (int i = 100; i < 501; i++)
        {
            for (int i2 = 350; i2 < 451; i2++)
            {
                wall[i][i2] = 1;
            }
        }
        for (int i = 0; i < 600; i++)
            for (int i2 = 0, i3 = 696; i2 < 104 && i3 < 801; i2++, i3++)
            {
                wall[i][i2] = 1;
                wall[i][i3] = 1;
            }
    }

    public static int get_wall(int x, int y)
    {
        return wall[y][x];
    }

    public static int check_wall(int x, int y, int delta, int size)
    {
        switch (delta)
        {
            case 1:
            {
                if (get_wall(x - size, y + size + 2) == 1 || get_wall(x + size, y + size + 2) == 1)
                {
                    return 1;
                }
                break;
            }
            case 2:
            {
                if (get_wall(x - size - 2, y - size) == 1 || get_wall(x - size - 2, y + size) == 1)
                {
                    return 2;
                }
                break;
            }
            case 3:
            {
                if (get_wall(x + size + 2, y - size) == 1 || get_wall(x + size + 2, y + size) == 1)
                {
                    return 3;
                }
                break;
            }
            case 4:
            {
                if (get_wall(x + size, y - size - 2) == 1 || get_wall(x - size, y - size - 2) == 1)
                {
                    return 4;
                }
                break;
            }
        }
        return 0;
    }

    public static int  check_tank(int x1, int y1, int delta1, int size, int x2, int y2)
    {
        int size2 = 25;
        switch (delta1)
        {
            case 1:
            {
                if ((x1 - size >= x2 - size2 && x1 - size <= x2 + size2 && y1 + size + 1 >= y2 - size2 && y1 + size + 1 <= y2 + size2)
                        || (x1 + size >= x2 - size2 && x1 + size <= x2 + size2 && y1 + size + 1 >= y2 - size2 && y1 + size + 1 <= y2 + size2))
                {
                    return 1;
                }
                break;
            }
            case 2:
            {
                if ((y1 - size >= y2 - size2 && y1 - size <= y2 + size2 && x1 - size - 1 >= x2 - size2 && x1 - size - 1 <= x2 + size2)
                        || (y1 + size >= y2 - size2 && y1 + size <= y2 + size2 && x1 - size - 1 >= x2 - size2 && x1 - size - 1 <= x2 + size2))
                {
                    return 2;
                }
                break;
            }
            case 3:
            {
                if ((y1 - size >= y2 - size2 && y1 - size <= y2 + size2 && x1 + size + 1 >= x2 - size2 && x1 + size + 1 <= x2 + size2)
                        || (y1 + size >= y2 - size2 && y1 + size <= y2 + size2 && x1 + size + 1 >= x2 - size2 && x1 + size + 1 <= x2 + size2))
                {
                    return 3;
                }
                break;
            }
            case 4:
            {
                if ((x1 - size >= x2 - size2 && x1 - size <= x2 + size2 && y1 - size - 1 <= y2 + size2 && y1 - size - 1 >= y2 - size2)
                        || (x1 + size >= x2 - size2 && x1 + size <= x2 + size2 && y1 - size - 1 <= y2 + size2 && y1 - size - 1 >= y2 - size2))
                {
                    return 4;
                }
                break;
            }
        }
        return 0;
    }

    public static void draw_pix()
    {
        Image.bind_map();
    }
}
