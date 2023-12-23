import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ball extends Obstacle
{
    public double direction;
    double dx;
    double dy;
    int speed;
    int livesRemaining;
    double myX;
    double myY;
    int startX;
    int startY;
    boolean lifeLost;
    double xBeforeIntersect=myX;
    double yBeforeIntersect=myY;
    boolean blockRemoved;
    boolean playerWon;
    int score;
    int highScore;
    int count;
    Border top=new Border(0,60,20000,15);
    Border bottom= new Border(0,1100,20000,15);
    Border left= new Border(0,0,15,20000);
    Border right = new Border(1300,0,15,20000);
    Paddle paddle;
    int prevX=0;
    int prevY=0;
    
    public Ball(int x, int y, int width, int height, int s, int h, Image img)
    { 
        super(x,y,width,height,s,h,img);
        myX=x;
        myY=y;
        speed = s;
        startX = x;
        startY = y;
        prevX = x;
        prevY = y;
        livesRemaining = 3;
        direction=(int)(Math.random()*40+320);
    }
    
    public void move(ArrayList<Block> blocks,Paddle paddle)
    {
        if(this.intersects(top))
        { 
            myX=myX-dx;
            myY=myY-dy;
            direction = (540-direction)%360;
        }
        else if(this.intersects(left))
        { 
            myX=myX-dx;
            myY=myY-dy;
            direction = 360-direction; 
        }
        else if(this.intersects(right))
        { 
            myX=myX-dx;
            myY=myY-dy;
            direction = 360-direction;
        }
        if(this.intersects(paddle))
        {
            myX=myX-dx;
            myY=myY-dy;
            if(paddle.dx>=0)
                direction = (360+(int)(Math.random()*45))%360;
            if(paddle.dx<0)
                direction = (360+(int)(Math.random()*45-45))%360;
            //if(paddle.dx==0)
                //direction=0;
        }     
        for(int b = 0; b<blocks.size(); b++)
        {
            if(this.intersects(blocks.get(b)))
            {
                myX=myX-dx;
                myY=myY-dy;
                int rand = 0;
                score+=50;
                while(rand==0)
                {
                    rand=(int)(Math.random()*5-2);
                }
                if(blocks.get(b).intersectsString(this).equals("TOP")||
                        blocks.get(b).intersectsString(this).equals("BOTTOM"))
                     direction = (540-direction)%360+rand;
                     
                else if(blocks.get(b).intersectsString(this).equals("RIGHT")||
                        blocks.get(b).intersectsString(this).equals("LEFT"))
                     direction = 360-direction+rand;

                blocks.get(b).setHealth(blocks.get(b).getHealth()-1);
                if(blocks.get(b).getHealth()==0)
                {
                    blocks.remove(blocks.get(b));
                    count++;
                    score+=200;
                }
            }
        }

        if(livesRemaining >= 0 && !lifeLost)
        {
            if(direction==0)
                direction=360;
        
            if(direction>0&&direction<=90)
            {
                dx=Math.sin(direction*Math.PI/180)*speed;
                dy=-1*Math.cos(direction*Math.PI/180)*speed;
            }
            if(direction>90&&direction<=180)
            {
                dx=Math.sin((180-direction)*Math.PI/180)*speed;
                dy=Math.cos((180-direction)*Math.PI/180)*speed;
            }
            if(direction>180&&direction<=270)
            {
                dx=-1*Math.cos((270-direction)*Math.PI/180)*speed;
                dy=Math.sin((270-direction)*Math.PI/180)*speed;
            }
            if(direction>270&&direction<=360)
            {
                dx=-1*Math.sin((360-direction)*Math.PI/180)*speed;
                dy=-1*Math.cos((360-direction)*Math.PI/180)*speed;
            }
            prevX=(int)myX;
            prevY=(int)myY;
            myX=myX+dx;
            myY=myY+dy;
            x=(int)myX;
            y=(int)myY;
                
            if(myY>990)
            {   livesRemaining-=1;
                lifeLost = true;
                myY=600;
                myX=650;
                score-=100;
                direction=(int)(Math.random()*360);
            }
        }
    }
    
    public double getDirection()
    { return direction; }
    public int getLivesRemaining()
    { return livesRemaining; }
    
    public boolean getPlayerWon()
    { return playerWon; }
    
    public int getSpeed()
    { return speed; }
    public void setSpeed(int s)
    { speed = s; }
    
    public int getCount()
    { return count; }
    
    public int getScore()
    { return score; }
    public int getHighScore()
    {
        if(score>highScore)
            highScore = score;
        return highScore;
    }
    
    public double getX(){ return (int)myX; }
    public double getY(){ return (int)myY; }
    
    public int getMyX(int x) { return (int)x; }
    
    public void playerWins()
    {
        count = 70;
        playerWon=true;
    }
    public void playerLoses()
    {
        livesRemaining = -1;
    }
    
    public void playerWonGam()
    {
        if(count==70)
            playerWon=true;
    }
    public void endGame(){}
    public void newGam()
    {
        if(livesRemaining < 0 || playerWon || getCount()==70)
        {
            lifeLost = false;
            playerWon=false;
            count=0;
            score=0;
            myX = startX;
            myY = startY;
            livesRemaining = 3;
        }
    }
    public void startGam()
    { 
        lifeLost = false;
        playerWon=false;
    }
    public void restartGam()
    {
        lifeLost = false;
        myX = startX;
        myY = startY;
        livesRemaining = 3;
        score = 0;
        direction=(int)(Math.random()*360);
    }
}
