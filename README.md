# BreakOut
A version of the classic arcade game BreakOut written in Java using IntelliJ IDEA. 

<img src='https://github.com/nohabean/BreakOut/blob/main/titleMenu.png' title='Home Screen' width='700px' alt='Opening screen of the game' />

Run the Frame class to create a game. There are 4 levels, each with increasing ball speed to make the game increasingly more difficult. Hit the number on the keyboard coresponding with the difficulty as instructed. The game will start and the ball will be in play. 

<img src='https://github.com/nohabean/BreakOut/blob/main/gameStart.png' title='New Game' width='700px' alt='The start of a new game' />

Use the left and right arrow keys to move the paddle from side to side. Hit the P key to pause the game. From the pause menu, there are additional options available. Hit the R key to resume the game. Hit the N key to start a new game - this will reset the score, number of lives, and bricks to their starting values. Hit Q to quit and close the game.

<img src='https://github.com/nohabean/BreakOut/blob/main/pauseScreen.png' title='Pause Screen' width='700px' alt='Pause screen shows when game is paused' />

Each brick color has a number of lives associated with it. A purple brick has one life which means it the ball hits it once, it will be destroyed. Cyan bricks have 2 lives, blue bricks have 3 lives, green bricks have 4 lives, yellow bricks have 5 lives, orange bricks have 6 lives, and red bricks have 7 lives. For bricks with multiple lives, if the ball hits the brick, it will lose a life and the brick color will change to the next brick. For example, if a yellow brick is hit, it will turn into a green brick. 

A running score will be kept during the game. Completely destroying a brick will earn the player 250 points. Downgrading a brick's number of lives (hitting a brick but not destroying it) will earn the player 50 points. Losing a life (ball falls out of play) will cost the player 100 points. 

At the end of the game, the final score for the round will be shown. A highscore will also be kept and shown. This highscore is only valid for the current frame. If the game is quit, the highscore resets to 0.

Keep the ball in play and don't let it fall below the paddle and off the screen. If you fail to catch the ball as it drops, a life will be lost. The player has a total of 4 lives - the starting ball and then 3 additional balls. Once a life is a lost, the ball will appear in its starting position. Hit the spacebar to get the ball in motion again. If all lives are lost, the player loses the game.

<img src='https://github.com/nohabean/BreakOut/blob/main/loseScreen.png' title='Lose Screen' width='700px' alt='Lose screen will show if the player loses. Displays score from the round and the current highscore.' />

To win, all bricks must be destroyed. Good luck and have fun.

<img src='https://github.com/nohabean/BreakOut/blob/main/winScreen.png' title='Win Screen' width='700px' alt='Win screen will show if the player wins. Displays score from the round and the highscore.' />
