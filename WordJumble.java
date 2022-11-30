package Java.project2.src;
import java.util.Random;

public class WordJumble extends Game {

    public WordJumble(WordsList wl, Random rng, int minWordLen, int maxWordLen, int maxGuesses)
    {
        mWordList = wl;
        mRng = rng;
        mMinWordLen = minWordLen;
        mMaxWordLen = maxWordLen;
        mMaxGuesses = maxGuesses;
    }

    @Override
    public String getName()
    {
        return "Word Jumble";
    }
    @Override
    protected String prepToPlay()
    {
        mWon = false;
        mNumGuesses = 0;
        mWordGuessed ="";
        mWordToGuess = mWordList.getWord(mMinWordLen, mMaxWordLen);

        //get random permutation of the letters in the word
        char[] s = mWordToGuess.toCharArray();
        for(int i = 0; i < mWordToGuess.length(); i++)
        {
          //swap the value with random index
           int j = mRng.nextInt(s.length);
           char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        //"cast" the array to a string
        return "The following is a jumbled up word : "+String.valueOf(s)+" You get "+mMaxGuesses+ "guesses to guess it";
    }
    @Override
    protected boolean isOver()
    {
        return mNumGuesses >= mMaxGuesses || mWordGuessed.equals(mWordToGuess);
    }
    @Override
    protected boolean isValid(String move)
    {
        //it will be a better idea to check if the len(move)<=len(mWordToGuess)
        return true;
    }
    @Override
    protected String processMove(String move)
    {
        mNumGuesses++;
        if(mWordToGuess.equals(move))
        {
            mWon = true;
            mWordGuessed = move;
            return "That's it!";
        }
        else
        {
            return "That's not it";
        }

    }
    @Override
    protected String finalMessage()
    {
        return "The word was "+mWordToGuess;
    }

    @Override 
    protected int howManyTrials()
    {
        return mMaxGuesses-mNumGuesses;
    }
    private WordsList mWordList;
    private Random mRng;
    private int mMaxGuesses;
    private int mMaxWordLen;
    private int mMinWordLen;

    private int mNumGuesses;
    private String mWordGuessed;
    private String mWordToGuess;
}