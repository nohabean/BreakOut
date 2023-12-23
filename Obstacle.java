import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Obstacle extends Rectangle
{  
    Image imgs;
    int speed;
    int health;
    public Obstacle(int x, int y, int width, int height, int s, int h, Image img)
    { 
        super(x,y,width,height); 
        imgs=img;
        speed=s;
        health=h;
    }
    public void move(){}
    public Image getImage()
    { return imgs; }
}
