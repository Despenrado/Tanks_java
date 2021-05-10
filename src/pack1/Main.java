package pack1;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

//                                           ===================================================================="
//                                           = Produced by Despenrado (Nikita Stepanenko) and Dmytro Matviichuk ="
//                                           ===================================================================="
public class Main
{
    public static void main(String[] args)
    {
        Map.set_wall();
        new Main();

        MyDisplay.ticks();
        Display.destroy();
        System.exit(0);
    }



    public Main()
    {
        Display.setTitle("Tanks");
        try
        {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            load_images();
        }
        catch(org.lwjgl.LWJGLException e)
        {
            e.printStackTrace();
            System.exit(0);
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,800,600,0,-1,1);
        //glMatrixMode(GL_MODELVIEW);
    }

    public static void load_images()
    {
        Image.load();
    }

}