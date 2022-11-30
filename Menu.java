package Java.project2.src;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Component;


public class Menu extends Component{

    
    public static void main(String[] args) {
     
        new Menu();
    }

    public  Score mScore;
    public static JPanel TITLE_PANEL;
    public static JPanel MENU_PANEL;
    public static Container CONTAINER;
    public static JFrame MAIN_FRAME;
    public static Game GAMES[];
    public static int  GAME_COUNT=5;
    public static JPanel SCORE_PANEL;

    JLabel mTitle;
    Font mTitleFont=new Font("Arial",Font.BOLD,50);

    JButton[] mButtons;
    Font mButtonFont=new Font("Arial",Font.BOLD,20);
    int mButtonWidth=300;
    int mButtonHeight=50;

    public Menu(){

      
        GAMES=GameGrabber.make_default_game();
        mScore=new Score();
        //create Title Panel
        TITLE_PANEL = new JPanel();
        TITLE_PANEL.setBackground(Color.BLACK);
        TITLE_PANEL.setBounds(0, 0, 400, 100);
        TITLE_PANEL.setLayout(null);
        TITLE_PANEL.setVisible(true);

        mTitle = new JLabel("Menu");
        mTitle.setFont(mTitleFont);
        mTitle.setBounds(100, 50, 200, 50);
        mTitle.setVisible(true);
        TITLE_PANEL.add(mTitle);

        //create Menu Panel
        MENU_PANEL = new JPanel();
        MENU_PANEL.setBackground(Color.black);
        MENU_PANEL.setBounds(50,100, 400, 400);
        MENU_PANEL.setLayout(null);
        MENU_PANEL.setVisible(true);

        //add buttons and set their properties
        mButtons = new JButton[ GAME_COUNT+1];
        for(int i=0;i< GAME_COUNT+1;i++){
            mButtons[i] = new JButton();
            mButtons[i].setBounds(50, 50+i*50, mButtonWidth, mButtonHeight);
            mButtons[i].setMargin(new Insets(50,50,50,50));
            mButtons[i].setBackground(Color.BLACK);
            mButtons[i].setFont(mButtonFont);
            mButtons[i].setVisible(true);
            mButtons[i].setFocusable(false);
            MENU_PANEL.add(mButtons[i]);

            if(i< GAME_COUNT){
                mButtons[i].setText(GAMES[i].getName());
                mButtons[i].addActionListener(new GameListener(i));
            }
            else{
                mButtons[i].setText("Quit");
                mButtons[i].addActionListener(new GameListener(i));

            }
        }

        //main "window" 
        MAIN_FRAME = new JFrame("Game Grabber");
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setSize(600, 500);
        MAIN_FRAME.getContentPane().setBackground(Color.BLACK);
    
        //add panels to main "window"
        CONTAINER = MAIN_FRAME.getContentPane();
        CONTAINER.setLayout(null);
        CONTAINER.add(TITLE_PANEL);
        CONTAINER.add(MENU_PANEL);
        MAIN_FRAME.setVisible(true);
  
    }
   
    class GameListener implements java.awt.event.ActionListener{
        int mGameIndex;
        
        public GameListener(int gameNum){
            mGameIndex=gameNum;
        }
        public void actionPerformed(java.awt.event.ActionEvent e){
            //quit if the last button is pressed
            if(e.getSource() == mButtons[GAME_COUNT]){
                JTextArea textArea = new JTextArea();

                textArea.setBounds(0, 0, 600, 600);
                textArea.setFont(new Font("Arial", Font.BOLD, 50));
                textArea.setWrapStyleWord(true);
                textArea.setText("Thanks for playing!");
                textArea.setEditable(false);
                textArea.setVisible(true);
                MAIN_FRAME.add(textArea);

                MAIN_FRAME.setVisible(true);
                MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }

            TITLE_PANEL.setVisible(false);
            MENU_PANEL.setVisible(false);
            GAMES = GameGrabber.make_default_game();
            GAMES[mGameIndex].play(CONTAINER, mScore);
            mScore.toLabel(CONTAINER);
            

        }
    }
}
