package Java.project2.src;

import java.util.Random;

public class TicTacToe extends Game {
    private char[][] board;
    private final char mPlayer = 'X';
    private final char mComputer = 'O';
   
    public TicTacToe( ) {
        // initialize board
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private String print_board(){
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += board[i][j];
            }
            s += "\n";
        }
        return s;
    }

    @Override
    public  String getName()
    {
        return "TicTacToe";
    }
    @Override
    protected String prepToPlay()
    {
        mWon = false;
        return "Welcome to TicTacToe!\n" +
                "The first player to get three in a row wins.\n"+
                "choose xy(like 00, 01 22 etc) to place your move. \n"+print_board()+"\n";

        
    }
    private boolean check_win(char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    private boolean check_tie() {
        //check if we have playable moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    protected boolean isOver()
    {
        //game is still playable if not won or tied
        if(check_win(mPlayer) || check_win(mComputer) || check_tie())
            return true;
        return false;
    }
    @Override
    protected boolean isValid(String move)
    {
        if(move.length()!=2)
            return false;
        //check if the move is valid by parsing the string
        try{
            int x = Integer.parseInt(move.substring(0,1));
            int y = Integer.parseInt(move.substring(1,2));
            if(x<0 || x>2 || y<0 || y>2)
                return false;
            if(board[x][y]!='-')
                return false;
            return true;
        }
        catch(Exception e){
            //being lazy and not checking for the exception
            return false;
        }
    }
    @Override
    protected String processMove(String move)
    {
        int x = Integer.parseInt(move.substring(0,1));
        int y = Integer.parseInt(move.substring(1,2));
        board[x][y] = mPlayer;
        if(check_win(mPlayer))
            return "You win!";
        if(check_tie())
            return "Tie!";
        Random rand = new Random();
        int x1 = rand.nextInt(3);
        int y1 = rand.nextInt(3);
        while(board[x1][y1]!='-'){
            x1 = rand.nextInt(3);
            y1 = rand.nextInt(3);
        }
        board[x1][y1] = mComputer;
        sleep(500);
                
        if(check_win(mComputer))
            return "Computer wins!";
        if(check_tie())
            return "Tie!";
        return print_board();
    }

    private void sleep(int i) {
        // while(i>0)
        // {
        //     i--;
        // }

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            //System.out.println(e);
        }
    }

    @Override
    protected String finalMessage()
    {
        if(check_win(mPlayer))
        {
            mWon = true;
            return "You win!";
        }
        if(check_win(mComputer))
        {
            mWon = false;
            return "Computer wins!";
        }
        return "Tie!";
    }
    @Override 
    protected int howManyTrials()
    {
        return 0;
    }

}
