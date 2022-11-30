package Java.project2.src;
import java.util.Random;

public class Hangman extends Game {

    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses)
    {
        mWords = words;
        mMaxGuesses = maxGuesses;
        mMinWordLen = minWordLen;
        mMaxWordLen = maxWordLen;
    }
   
    @Override
    public  String getName()
    {
        return "Hangman";
    }
    @Override
    protected String prepToPlay()
    {
        mWordToGuess= mWords.getWord(mMinWordLen, mMaxWordLen);
        mWon = false;
        //initialize the  word to guess with the correct number of underscores
        for(int i =0; i<mWordToGuess.length(); i++)
        {
            mWordGuessed+="_";
        }
        return "I’ve picked a "+mWordToGuess.length()+" letter word, "+
             "guess letters you think are in the word. You get " +mMaxGuesses+ " guesses.\n";
    }
    @Override
    protected boolean isOver()
    {
        if(mWordGuessed.equals(mWordToGuess))
        {
            mWon = true;
            return true;
        }
        else if(mNumOfGuesses>mMaxGuesses){
            mWon = false;
            return true;

        }
        return false;
    }
    @Override
    protected boolean isValid(String move)
    {
        //since the move is a single character, it is valid if it is a letter
        return move.length() == 1 && Character.isLetter(move.charAt(0));
    }
    @Override
    protected String processMove(String move)
    {
        mNumOfGuesses++;
        if(mWordToGuess.contains(move))
        {
            for(int i =0; i<mWordToGuess.length(); i++)
            {
                //replace the _ with the move if it is in the word
                if(mWordToGuess.charAt(i)==move.charAt(0))
                {
                    mWordGuessed=mWordGuessed.substring(0,i)+move+mWordGuessed.substring(i+1);
                }
            }
        }
        return mWordGuessed;
    }
    @Override
    protected String finalMessage()
    {
        return "The word was: "+mWordToGuess;
    }
    
    
    @Override 
    protected int howManyTrials()
    {
        return mMaxGuesses-mNumOfGuesses;
    }
    
    private WordsList mWords;
    private int mMinWordLen;
    private int mMaxWordLen;
    private int mMaxGuesses;
    
    private String mWordToGuess="";
    private String mWordGuessed="";
    private int mNumOfGuesses;

}