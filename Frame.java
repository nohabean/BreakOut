import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends Canvas
{
    Board myBoard;
    
    public Frame()
    {
       JFrame f = new JFrame("BreakOut"); 
       myBoard = new Board();
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),"left");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"),"stop left");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),"right");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"),"stop right");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"),"new game");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"),"start");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("P"),"pause");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("R"),"resume");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("N"),"restart");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"),"quit");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"),"win");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("L"),"lose");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"),"beginner");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"),"intermediate");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"),"advanced");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("4"),"expert");
       
       /* myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),"up");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"),"stop up");
       
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),"down");
       myBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released DOWN"),"stop down"); */
       
       myBoard.getActionMap().put("left", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.left(); }
       });
       myBoard.getActionMap().put("stop left", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.stopLeft(); }
       });
       
       myBoard.getActionMap().put("right", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.right(); }
       });
       myBoard.getActionMap().put("stop right", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.stopRight(); }
       });
       
       myBoard.getActionMap().put("new game", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.newGame(); }
       });
       
       myBoard.getActionMap().put("start", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(myBoard.isGameStarted())
                   myBoard.startGame();
           }
       });
       
       myBoard.getActionMap().put("pause", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.pauseGame(); }
       });
       
       myBoard.getActionMap().put("resume", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.resumeGame(); }
       });
       
       myBoard.getActionMap().put("restart", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { myBoard.restartGame(); }
       });
       
       myBoard.getActionMap().put("quit", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(myBoard.isGamePaused())
                   System.exit(0); 
           }
       });
       
       myBoard.getActionMap().put("win", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               myBoard.winGame();
           }
       });
       
       myBoard.getActionMap().put("lose", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               myBoard.loseGame();
           }
       });
       
        myBoard.getActionMap().put("beginner", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(!myBoard.isGameStarted())
               {
                   myBoard.setDifficultyOne();
                   myBoard.startGame();
               }
           }
       });
        myBoard.getActionMap().put("intermediate", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(!myBoard.isGameStarted())
               {
                   myBoard.setDifficultyTwo();
                   myBoard.startGame();
               }
           }
       });
        myBoard.getActionMap().put("advanced", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(!myBoard.isGameStarted())
               {
                   myBoard.setDifficultyThree();
                   myBoard.startGame();
               }
           }
       });
        myBoard.getActionMap().put("expert", new AbstractAction()
       {
           public void actionPerformed(ActionEvent e)
           { 
               if(!myBoard.isGameStarted())
               {
                   myBoard.setDifficultyFour();
                   myBoard.startGame();
               }
           }
       });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.add(myBoard);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1300, screenSize.height);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
    
    public static void main(String [] args)
    {
        new Frame();
    }
}
