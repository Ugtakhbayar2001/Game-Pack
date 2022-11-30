package Java.project2.src;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Container;

public class Score {
    private int mPlayedTimes;
    private int mWins;
    private int mLoses;
    public Score(int howManyTimesPlayed, int howManyWins, int howManyLoses)
    {
        mPlayedTimes = howManyTimesPlayed;
        mWins = howManyWins;
        mLoses = howManyLoses;
    }
    public Score(){
        mPlayedTimes = 0;
        mWins = 0;
        mLoses = 0;
    }
    @Override
    public String toString()
    {
        return "You played: "+ mPlayedTimes +" won: "+ mWins+" Lost: "+mLoses;
    }
    public void incrementWins()
    {
        mPlayedTimes+=1;
        mWins+=1;   
    }
    public void incrementLosses(){
        mPlayedTimes+=1;
        mLoses+=1;
    }
    public void toLabel(Container panel)
    {

        JLabel label = new JLabel("Played:" + mPlayedTimes + " Won:" + mWins + " Lost:" + mLoses);
        label.setBounds(0, 0, 400, 300);
        label.setFont(panel.getFont());
        panel.add(label);
    }
}
