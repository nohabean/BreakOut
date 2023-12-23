import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class Board extends JPanel implements ActionListener
{
    Font trigramLightFont;
    Timer time;
    Image background;
    Image bar;
    Image bouncyBall;
    Image threeLivesLeft;
    Image twoLivesLeft;
    Image oneLifeLeft;
    Image noLivesLeft;
    Image gameOver;
    Image pressEnter;
    Image startGame;
    Image highScore;
    Image redBlock;
    Image orangeBlock;
    Image yellowBlock;
    Image greenBlock;
    Image blueBlock;
    Image cyanBlock;
    Image purpleBlock;
    Image pauseScreen;
    Image ilivesRemaining;
    Image livesR;
    Image scoreBoard;
    Image gamePause;
    Image gameResume;
    Image gameRestart;
    Image closeGame;
    Image topBanner;
    Image endScore;
    Image youWon;
    Image title;
    Image selectDifficulty;
    Image easy;
    Image medium;
    Image hard; 
    Image xtreme;
    int livesRemaining;
    int score;
    boolean gameStarted;
    boolean gamePaused;
    boolean lifeLost;
    boolean playerWon;
    boolean blockRemoved;
    Paddle paddle;
    Ball ball;
    ArrayList<Block> blocks = new ArrayList<Block>();

    public Board()
    {
        ImageIcon i = new ImageIcon("bg.jpg");
            background = i.getImage();
        ImageIcon i2 = new ImageIcon("bar.png");
            bar = i2.getImage();
        ImageIcon i3 = new ImageIcon("pauseScreen.png");
            pauseScreen = i3.getImage();
        ImageIcon i4 = new ImageIcon("ball.png");
            bouncyBall = i4.getImage();
        ImageIcon i5 = new ImageIcon("ThreeLivesLeft.png");
            threeLivesLeft = i5.getImage();
        ImageIcon i6 = new ImageIcon("TwoLivesLeft.png");
            twoLivesLeft = i6.getImage();
        ImageIcon i7 = new ImageIcon("OneLifeLeft.png");
            oneLifeLeft = i7.getImage();
        ImageIcon i8 = new ImageIcon("NoLivesLeft.png");
            noLivesLeft = i8.getImage();
        ImageIcon i9 = new ImageIcon("GAMEOVER.png");
            gameOver = i9.getImage();
        ImageIcon i10 = new ImageIcon("PressENTER.png");
            pressEnter = i10.getImage();
        ImageIcon i11 = new ImageIcon("pressSPACE.png");
            startGame = i11.getImage();
        ImageIcon i12 = new ImageIcon("HighScore.png");
            highScore = i12.getImage();
        ImageIcon i13 = new ImageIcon("redBlock.png");
            redBlock = i13.getImage();
        ImageIcon i14 = new ImageIcon("orangeBlock.png");
            orangeBlock = i14.getImage();
        ImageIcon i15 = new ImageIcon("yellowBlock.png");
            yellowBlock = i15.getImage();
        ImageIcon i16 = new ImageIcon("greenBlock.png");
            greenBlock = i16.getImage();
        ImageIcon i17 = new ImageIcon("blueBlock.png");
            blueBlock = i17.getImage();
        ImageIcon i18 = new ImageIcon("cyanBlock.png");
            cyanBlock = i18.getImage();
        ImageIcon i19 = new ImageIcon("purpleBlock.png");
            purpleBlock = i19.getImage();
        ImageIcon i20 = new ImageIcon("LivesRemaining.png");
            ilivesRemaining = i20.getImage();
        ImageIcon i21 = new ImageIcon("livesR.png");
            livesR = i21.getImage();
        ImageIcon i22 = new ImageIcon("Score.png");
            scoreBoard = i22.getImage();
        ImageIcon i23 = new ImageIcon("GamePaused.png");
            gamePause = i23.getImage();
        ImageIcon i24 = new ImageIcon("PressR.png");
            gameResume = i24.getImage();
        ImageIcon i25 = new ImageIcon("PressN.png");
            gameRestart = i25.getImage();
        ImageIcon i26 = new ImageIcon("PressQ.png");
            closeGame = i26.getImage();
        ImageIcon i27 = new ImageIcon("topBanner.png");
            topBanner = i27.getImage();
        ImageIcon i28 = new ImageIcon("endScore.png");
            endScore = i28.getImage();
        ImageIcon i30 = new ImageIcon("YouWon.png");
            youWon = i30.getImage();
        ImageIcon i31 = new ImageIcon("title.png");
            title = i31.getImage();
        ImageIcon i32 = new ImageIcon("SelectDifficulty.png");
            selectDifficulty = i32.getImage();
        ImageIcon i33 = new ImageIcon("PressOne.png");
            easy = i33.getImage();
        ImageIcon i34 = new ImageIcon("PressTwo.png");
            medium = i34.getImage();
        ImageIcon i35 = new ImageIcon("PressThree.png");
            hard = i35.getImage();
        ImageIcon i36 = new ImageIcon("PressFour.png");
            xtreme = i36.getImage();
            
        paddle = new Paddle(600,820,110,15,15,1,bar);
        ball = new Ball(635,600,20,20,8,1,bouncyBall);
        for(int x = 0; x<10; x++)
        {
            blocks.add(new Block(x*115 + 80,130,100,50,1,7,redBlock));
            blocks.add(new Block(x*115 + 80,195,100,50,1,6,orangeBlock));
            blocks.add(new Block(x*115 + 80,260,100,50,1,5,yellowBlock));
            blocks.add(new Block(x*115 + 80,325,100,50,1,4,greenBlock));
            blocks.add(new Block(x*115 + 80,390,100,50,1,3,blueBlock));
            blocks.add(new Block(x*115 + 80,455,100,50,1,2,cyanBlock));
            blocks.add(new Block(x*115 + 80,520,100,50,1,1,purpleBlock));
        }

        try {
            InputStream fontStream = getClass().getResourceAsStream("Trigram-Light.ttf");
            Font trigramBaseFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);

            trigramLightFont = trigramBaseFont.deriveFont(Font.PLAIN, 50);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        //16 is 60 fps and 33 is 30 fps
        time = new Timer(16,this);
        time.start();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(gameStarted && !gamePaused && !lifeLost && !playerWon)
        {
            paddle.move();
            ball.move(blocks,paddle);
        }
        repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;  
        if(gameStarted)
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            g.setColor(Color.BLACK);
            g2d.fillRect(0,0,1300, screenSize.height);
            g2d.drawImage(topBanner,0,0,null);
            
            g2d.drawImage(paddle.getImage(),(int)paddle.getX(),(int)paddle.getY(),null);
            g2d.drawImage(ball.getImage(),(int)ball.getX(),(int)ball.getY(),null);
            g2d.drawImage(ilivesRemaining,520,3,null);
            g2d.drawImage(scoreBoard,15,3,null);
            g2d.drawImage(livesR,240,0,null);
            g2d.drawImage(livesR,1100,0,null);
            g2d.setColor(Color.WHITE);
            g2d.setFont(trigramLightFont);
            g2d.drawString("" + ball.getScore(),275,49);
            
            for(Block b: blocks)
            {
                if(b.getHealth()==7)
                    g2d.drawImage(redBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==6)
                    g2d.drawImage(orangeBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==5)
                    g2d.drawImage(yellowBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==4)
                    g2d.drawImage(greenBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==3)
                    g2d.drawImage(blueBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==2)
                    g2d.drawImage(cyanBlock,(int)b.getX(),(int)b.getY(),null);
                if(b.getHealth()==1)
                    g2d.drawImage(purpleBlock,(int)b.getX(),(int)b.getY(),null);
            }
            
            if(gamePaused)
            {
                g2d.drawImage(pauseScreen,335,285,null);
                g2d.drawImage(gamePause,440,350,null);
                g2d.drawImage(gameResume,365,480,null);
                g2d.drawImage(gameRestart,375,540,null);
                g2d.drawImage(closeGame,406,600,null);
            }
            
            if(ball.getLivesRemaining() == 3)
                g2d.drawImage(threeLivesLeft,1135,8,null);
            if(ball.getLivesRemaining() == 2)
                g2d.drawImage(twoLivesLeft,1135,8,null);
            if(ball.getLivesRemaining() == 1)
                g2d.drawImage(oneLifeLeft,1135,8,null);
            if(ball.getLivesRemaining() == 0)
                g2d.drawImage(noLivesLeft, 1135,8,null);
            if(ball.getLivesRemaining() < 0)
            {    
                ball.endGame();
                g.setColor(Color.BLACK);
                g2d.fillRect(0,0,1300,screenSize.height);
                g2d.drawImage(gameOver,290,50,null);
                g2d.drawImage(pressEnter,300,700,null);
                g2d.drawImage(endScore,460,250,null);
                g2d.drawImage(highScore,335,475,null);
                
                if(ball.getScore()==0)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),625,425);
                }
                if(ball.getScore()>0 && ball.getScore()<100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),590,425);
                }
                if(ball.getScore()>=100 && ball.getScore()<1000 || ball.getScore()<0 && ball.getScore()>-100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),560,425);
                }
                if(ball.getScore()>=1000 && ball.getScore()<10000 || ball.getScore()<=-100 && ball.getScore()>-1000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),530,425);
                }
                if(ball.getScore()>=10000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),500,425);
                }

                if(ball.getHighScore()==0)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),625,425);
                }
                if(ball.getHighScore()>0 && ball.getHighScore()<100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),590,650);
                }
                if(ball.getHighScore()>=100 && ball.getHighScore()<1000 || ball.getHighScore()<0 && ball.getHighScore()>-100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),560,650);
                }
                if(ball.getHighScore()>=1000 && ball.getHighScore()<10000 || ball.getHighScore()<=-100 && ball.getHighScore()>-1000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),530,650);
                }
                if(ball.getHighScore()>=10000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),490,650);
                }

                gamePaused = false;
            }

            if(ball.getPlayerWon() || ball.getCount() == 70)
            {
                ball.playerWonGam();
                playerWon=true;
                gamePaused=false;
                g.setColor(Color.BLACK);
                g2d.fillRect(0,0,1300,screenSize.height);
                g2d.drawImage(youWon,350,50,null);
                g2d.drawImage(pressEnter,300,700,null);
                g2d.drawImage(endScore,460,250,null);
                g2d.drawImage(highScore,325,475,null);

                if(ball.getScore()==0)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),625,425);
                }
                if(ball.getScore()>0 && ball.getScore()<100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),590,425);
                }
                if(ball.getScore()>=100 && ball.getScore()<1000 || ball.getScore()<0 && ball.getScore()>-100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),560,425);
                }
                if(ball.getScore()>=1000 && ball.getScore()<10000 || ball.getScore()<=-100 && ball.getScore()>-1000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),530,425);
                }
                if(ball.getScore()>=10000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getScore(),500,425);
                }

                if(ball.getHighScore()==0)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),625,650);
                }
                if(ball.getHighScore()>0 && ball.getHighScore()<100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),590,650);
                }
                if(ball.getHighScore()>=100 && ball.getHighScore()<1000 || ball.getHighScore()<0 && ball.getHighScore()>-100)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),560,650);
                }
                if(ball.getHighScore()>=1000 && ball.getHighScore()<10000 || ball.getHighScore()<=-100 && ball.getHighScore()>-1000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),530,650);
                }
                if(ball.getHighScore()>=10000)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(trigramLightFont.deriveFont(Font.PLAIN, 65));
                    g2d.drawString("" + ball.getHighScore(),490,650);
                }
            }
        }
        if(!gameStarted)
        {
            ball.startGam();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            g.setColor(Color.BLACK);
            g2d.fillRect(0,0,1300,screenSize.height);
            g2d.drawImage(title,225,70,null);
            g2d.drawImage(selectDifficulty,100,375,null);
            g2d.drawImage(easy,270,500,null);
            g2d.drawImage(medium,215,575,null);
            g2d.drawImage(hard,270,650,null);
            g2d.drawImage(xtreme,180,725,null);
        }
    }

    public void left()
    { paddle.left(); }
    public void stopLeft()
    { paddle.stopLeft(); }
    public void right()
    { paddle.right(); }
    public void stopRight()
    { paddle.stopRight(); }
    
    public void setDifficultyOne()
    { 
        if(!gameStarted){ball.setSpeed(6);
        paddle.setSpeed(10);}
    }
    public void setDifficultyTwo()
    { 
        if(!gameStarted){ball.setSpeed(10);
        paddle.setSpeed(14);}
    }
    public void setDifficultyThree()
    { 
        if(!gameStarted){ball.setSpeed(14);
        paddle.setSpeed(18);}
    }
    public void setDifficultyFour()
    { 
        if(!gameStarted){ball.setSpeed(18);
        paddle.setSpeed(22);}
    }
    
    public void resetBlocks()
    {  
        blocks = new ArrayList<Block>();
        for(int x = 0; x<10; x++)
        {
            blocks.add(new Block(x*115 + 80,130,100,50,1,7,redBlock));
            blocks.add(new Block(x*115 + 80,195,100,50,1,6,orangeBlock));
            blocks.add(new Block(x*115 + 80,260,100,50,1,5,yellowBlock));
            blocks.add(new Block(x*115 + 80,325,100,50,1,4,greenBlock));
            blocks.add(new Block(x*115 + 80,390,100,50,1,3,blueBlock));
            blocks.add(new Block(x*115 + 80,455,100,50,1,2,cyanBlock));
            blocks.add(new Block(x*115 + 80,520,100,50,1,1,purpleBlock));
        }
    }
    
    public void startGame()
    { 
        ball.startGam();
        gameStarted = true;
    }
    
    public void winGame()
    {
        ball.playerWins();
    }
    public void loseGame()
    {
        ball.playerLoses();
    }
    
    public void pauseGame()
    { 
        if(gameStarted)
            gamePaused = true; 
    }
    
    public void resumeGame()
    { gamePaused = false; }
    
    public void newGame()
    {
        if(ball.getLivesRemaining() < 0 || ball.getPlayerWon() || ball.getCount()==70)
        {
            lifeLost = false;
            playerWon = false;
            ball.newGam();
            paddle.resetGame();
            gameStarted = false;
            resetBlocks();
        }
    }
    
    public void restartGame()
    {
        if(gamePaused)
        {
            ball.restartGam();
            paddle.resetGame();
            resetBlocks();
            gamePaused = false;
            gameStarted = false;
        }
    }
    
    public boolean isGamePaused()
    { return gamePaused; }
    public boolean isGameStarted()
    { return gameStarted; }
    
    public static synchronized void playSound(final String url)
    {
        new Thread(new Runnable() 
        {
            public void run()
            {
                try
                {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(Board.class.getResourceAsStream(url));
                    
                    clip.open(inputStream);
                    clip.start();
                    //Board.playSound(".wav") in any class
                }
                catch (Exception e) {}
            }
        }).start();
    }
}
