package Java.project2.src;

import java.util.Random;
import java.util.Scanner;


public class GameGrabber {
    public GameGrabber(Game[] games, Scanner user)
    {
        mGames =  new Game[games.length];
        mGames = games;
        mPlayer = user;
        mScore = new Score(0, 0, 0);
    }
    /**
     * This method will allow the user to select a game to play.
     */
    public void doMenu()
    {
        int choice = 0;
        while(choice != mGames.length)
        {
            //Prints out the menu
            System.out.println(mScore);
            System.out.println("Pick a game(0 - "+mGames.length+")");
            for(int i =0; i < mGames.length; i++)
            {
                System.err.println(i+" "+mGames[i].getName());
            }
            System.out.println(mGames.length+") Exit");

            //get valid input for game
            choice = mPlayer.nextInt();
            while(choice>mGames.length || choice<0)
            {
                System.err.println("Pick a game(0 - "+mGames.length+")");
                choice = mPlayer.nextInt();
            }

            //run the game
            if (choice == mGames.length)
            {
                System.out.println("Goodbye");
            }
            else
            {
                mGames[choice].play(mPlayer);
                if(mGames[choice].mWon == true)
                {
                    mScore.incrementWins();
                }
                else{
                    mScore.incrementLosses();
                }
            }
        }
    }

    public Game[] getGames()
    {
        return mGames;
    }
    static public Game[] make_default_game()
    {
       //create games. This was a neat design decision.
       Game[] games = new Game[5];
       Random rng = new Random();
       games[0] = new Hangman(new WordsList(rng), 5, 10, 20);
       games[1] = new NumberGuesser(rng, 100, 8);
       games[2] = new RPS(rng, 2,2);
       games[3] = new WordJumble(new WordsList(rng),rng, 3, 10, 8);
       games[4]= new TicTacToe();
       return games;
    }
    
    public static void runGames()
    {

       Game games[] = make_default_game();
       
        //create the game grabber
        GameGrabber gameGrabber = new GameGrabber(games, new Scanner(System.in));

        //run the menu
        gameGrabber.doMenu();
    }
    public static void main(String[] args)
    {
        runGames();
    }
    private Game[] mGames;
    private Scanner mPlayer;
    private Score mScore;

}
