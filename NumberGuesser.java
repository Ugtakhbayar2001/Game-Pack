package Java.project2.src;

import java.util.Random;

public class NumberGuesser extends Game {

    public NumberGuesser(Random rng, int maxNumber, int maxGuesses)
    {
        mRng = rng;
        mMaxNumber = maxNumber;
        mMaxGuesses = maxGuesses;
    }
    
    @Override
    public  String getName()
    {
        return "Number Guesser";
    }
    @Override
    protected String prepToPlay()
    {
        mWon = false;
        mNumber = mRng.nextInt(mMaxNumber) + 1;
        return "I'm thinking of a number between 1 and " + mMaxNumber + ". You have " + mMaxGuesses + " guesses.";
    }
    @Override
    protected boolean isOver()
    {
        return mGuesses>mMaxGuesses || mNumberToGuess==mNumber;
    }
    @Override
    protected boolean isValid(String move)
    {
        //try to parse the move as an integer and return true if it succeeds
        try
        {
            mNumberToGuess = Integer.parseInt(move);
            return mNumberToGuess>0 && mNumberToGuess<=mMaxNumber;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    @Override
    protected String processMove(String move)
    {
        mGuesses++;
        if(mNumberToGuess==mNumber)
        {
            mWon = true;
            return "Thats it!";
        }
        else if(mNumberToGuess<mNumber)
        {
            return "Your guess is too low.";
        }
        else
        {
            return "Your guess is too high.";
        }
    }
    @Override
    protected String finalMessage()
    {
        return "The number was " + mNumber + ".";
    }

    @Override 
    protected int howManyTrials()
    {
        return mMaxGuesses-mGuesses;
    }

    private Random mRng;
    private int mMaxNumber;
    private int mMaxGuesses;

    private int mNumber;
    private int mNumberToGuess;
    private int mGuesses;
}