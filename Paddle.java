import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Paddle extends Rectangle
{
    Image myImage;
    int dx;
    int dy;
    int speed;
    int health;
    int startX;
    int startY;
    int livesRemaining;
    Rectangle left;
    Rectangle right;
    Rectangle top;
    Rectangle bottom;
    
    public Paddle(int x, int y, int width, int height, int s, int h, Image img)
    {
        super(x,y,width,height);
        startX = x;
        startY = y;
        speed = s;
        health = h;
        myImage = img;
        dx = 0;
        dy = 0;
        left = new Rectangle(x,y,1,110);
        right = new Rectangle(x+110,y,1,110);
        top = new Rectangle(x,y,15,1);
        bottom = new Rectangle(x,y+15,15,1);
    }
    
    public Image getImage()
    { return myImage; }
    public double getX()
    { return x; }
    public void setSpeed(int s)
    { speed = s; }
    
    public void move()
    {
        x+=dx;
        if(x>1190)
            x=x-dx;
        if(x<0)
            x=x-dx;
    }
    
    public void left()
    { dx=-speed; }
    public void stopLeft()
    { dx=0; }
    public void right()
    { dx=speed; }
    public void stopRight()
    { dx=0; }
    public void up()
    { dy=-speed; }
    public void stopUp()
    { dy=0; }
    public void down()
    { dy=speed; }
    public void stopDown()
    { dy=0; }
    
    public void resetGame()
    {
        x=startX;
        y=startY;
    }
    
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
