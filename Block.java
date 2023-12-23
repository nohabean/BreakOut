import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Block extends Obstacle
{
    int health;
    Rectangle left;
    Rectangle right;
    Rectangle top;
    Rectangle bottom;
    public Block(int x, int y, int width, int height, int s, int h, Image img)
    {
        super(x,y,width,height,s,h,img);
        health = h;
        left = new Rectangle(x,y,1,50);
        right = new Rectangle(x+100,y,1,50);
        top = new Rectangle(x,y,100,1);
        bottom = new Rectangle(x,y+50,100,1);
    }
    public void move(){}
    
    public int getHealth()
    { return health; }
    public void setHealth(int h)
    { health = h; }
    
    public String intersectsString(Rectangle other)
    {
        boolean b = intersects(other);
        if(b==false)
        return "NO";
        
        if(other.intersects(top))
        return "TOP";
        if(other.intersects(bottom))
        return "BOTTOM";
         if(other.intersects(left))
        return "LEFT";
        if(other.intersects(right))
        return "RIGHT";

        return "INSIDE";
    }
}
