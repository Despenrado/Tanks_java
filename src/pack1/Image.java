package pack1;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import java.io.IOException;

public class Image
{
    private static Texture texture_menu;
    private static Texture texture_pause;
    private static Texture texture_you_win;
    private static Texture texture_game_over;
    private static Texture texture_player1_win;
    private static Texture texture_player2_win;
    private static Texture texture_bind_map;
    public static Texture texture_bind_tank;
    public static Texture texture_bind_tank_bot;
    public static Texture texture_bind_bullet;



    public static void load() {

        try {
            texture_menu = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/menu.png"));
            texture_pause = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/pause.png"));
            texture_you_win = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/you_win.png"));
            texture_game_over = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/game_over.png"));
            texture_player1_win = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/player1.png"));
            texture_player2_win = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/player2.png"));
            texture_bind_map = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/map.png"));
            texture_bind_bullet = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bullet.png"));
            texture_bind_tank = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tank.png"));
            texture_bind_tank_bot = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tank_bot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void draw_menu()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_menu.bind();
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_menu.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_menu.getTextureWidth(),texture_menu.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_menu.getTextureHeight());
        GL11.glEnd();
    }

    public static void draw_pause()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_pause.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_pause.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_pause.getTextureWidth(),texture_pause.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_pause.getTextureHeight());
        GL11.glEnd();
    }

    public static void draw_you_win()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_you_win.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_you_win.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_you_win.getTextureWidth(),texture_you_win.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_you_win.getTextureHeight());
        GL11.glEnd();
    }

    public static void draw_game_over()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_game_over.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_game_over.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_game_over.getTextureWidth(),texture_game_over.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_game_over.getTextureHeight());
        GL11.glEnd();
    }

    public static void draw_player1_win()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_player1_win.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_player1_win.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_player1_win.getTextureWidth(),texture_player1_win.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_player1_win.getTextureHeight());
        GL11.glEnd();
    }

    public static void draw_player2_win()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        texture_player2_win.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f( texture_player2_win.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f( texture_player2_win.getTextureWidth(), texture_player2_win.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0, texture_player2_win.getTextureHeight());
        GL11.glEnd();
    }

    public static void bind_map()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        texture_bind_map.bind();

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(texture_bind_map.getTextureWidth(),0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(texture_bind_map.getTextureWidth(),texture_bind_map.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,texture_bind_map.getTextureHeight());
        GL11.glEnd();
    }


    public static void bind_tank()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        texture_bind_tank.bind();;
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
    }

    public static void bind_tank_bot()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        texture_bind_tank_bot.bind();
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
    }

    public static void bind_bullet()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        texture_bind_bullet.bind();
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
    }
}
