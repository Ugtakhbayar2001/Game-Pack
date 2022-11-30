package Java.project2.src;



import java.util.Random;
import java.util.Scanner;

//all of these are used for the play that takes boolean value
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public abstract class Game {

    protected boolean mWon;

    /** 
     * initializes the game state
     */
    protected abstract String prepToPlay();
    /**
     *  check if the game is over
     */
    protected abstract boolean isOver();
    /**
     * check if the @param move is correct
     */
    protected abstract boolean isValid(String move);
    /**
     *  updates the game instance with the @param move 
     */
    protected abstract String processMove(String move);
    /**
     *  returns the final message of the game
     */
    protected abstract String finalMessage();
    /**
     * returns the name of the game
     */
    public abstract String getName();


    public boolean Won()
    {
        return mWon;
    }

    /**
     * The main method. It is the entry point of each game instance
     */
    public void play(Scanner user)
    {
        String move = "";
        System.out.println(prepToPlay());
        //game loop
        while(!isOver())
        {
            //get Valid move
            System.out.print("Enter Your Move or 'quit' to quit >");
        
            move = user.next();
            if(move.equals("quit"))
            {
                // System.out.println("Thanks for playing!");
                break;
            }
            while(!isValid(move))
            {
                System.out.print("Invalid Move ! try again > ");
                move = user.nextLine();
            }
            // 
           System.out.println(processMove(move));
        }
        System.out.println(finalMessage());
    }


    ///////////////////////////////From here it is not part of the assignment///////////////////////////////////////////////
    ///////////////////////////////From here it is not part of the assignment///////////////////////////////////////////////

    protected abstract int howManyTrials();

    /**
     * This was just a test method to learn how to use the "swing library" i have mostly used 
     * the JPanel and JLabel to create the GUI.
     * This method is used to display the game to the Frame. 
     * @param container the container to add the components to
     */
    public void play(Container container, Score score)
    {
        Font title_font=new Font("Arial",Font.BOLD,30);
        JPanel game_panel = new JPanel();
        game_panel.setBackground(Color.BLACK);
        game_panel.setBounds(0, 0, (int)container.getSize().getWidth(),  (int)container.getSize().getWidth());
        game_panel.setLayout(null);
        game_panel.setVisible(true);

        JLabel gameTitle = new JLabel(this.getName(), JLabel.CENTER);
        gameTitle.setFont(title_font);
        gameTitle.setBounds(100, 50, 200, 50);
        gameTitle.setVisible(true);

        //implements back button to return to the main menu
        JButton back_button = new JButton("Go Back");
        back_button.setBounds(0, 0, 100, 50);
        back_button.setForeground(Color.RED);
        back_button.setVisible(true);
        back_button.addActionListener(e -> {
            container.removeAll();
            container.add(new Menu());
            score.toLabel(container);
            container.repaint();
        });
        //implements hearts to show the number of trials left
        
        
        JLabel hearts = new JLabel(_hearts(howManyTrials()), JLabel.CENTER);
        hearts.setFont(new Font("Arial", Font.BOLD, 20));
        hearts.setForeground(Color.RED);

        hearts.setForeground(Color.RED);
        hearts.setBounds(100, 0, 200, 50);

        hearts.setVisible(true);

        //TextArea for displaying the game instructions
        JTextArea game_message_text = new JTextArea(this.prepToPlay());
        game_message_text.setBounds(100, 100, 400, 400);
        game_message_text.setVisible(true);
        game_message_text.setEditable(false);
        game_message_text.setLineWrap(true);
        game_message_text.setWrapStyleWord(true);
        game_message_text.setBackground(Color.BLACK);
        game_message_text.setForeground(Color.WHITE);
        game_message_text.setFont(new Font("Arial",Font.BOLD,20));

        //TextField for taking the user input
        JTextField user_input = new JTextField();
        user_input.setBounds(100, 300, 200, 50);
        user_input.setVisible(true);
        user_input.setEditable(true);
        user_input.setBackground(Color.BLACK);
        user_input.setForeground(Color.WHITE);
        user_input.setFocusable(true);
        
        user_input.setFont(new Font("Arial",Font.BOLD,20));

        //Button for submitting the user input
        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(100, 350, 100, 50);
        submit_button.setVisible(true); 
        //while game is not over, keep asking for user input

        submit_button.addActionListener(e -> {
            String move = user_input.getText();
            hearts.setText(_hearts(howManyTrials()));
            user_input.setText("");

            if(move.equals("quit"))
            {
                // System.out.println("Thanks for playing!");
                container.removeAll();
                container.add(new Menu());
                container.repaint();
            }
           else if(isValid(move))
            {
                game_message_text.setText(processMove(move));
                Random r = new Random();
                Color random_color = new Color(r.nextInt(254)+1, r.nextInt(254)+1, r.nextInt(254)+1);
                game_message_text.setForeground(random_color);;
                user_input.setText("");
            }
            else
            {
                game_message_text.setText("Invalid Move ! try again");
            }
            if (isOver())
            {
                game_message_text.setText(finalMessage());
                hearts.setText("");
                submit_button.setVisible(false);
                user_input.setVisible(false);
              

            }
        });
        
        if(Won())
        {
            score.incrementWins();
        }
        else
        {
            score.incrementLosses();
        }
        //combine all the components into the game panel and container
        game_panel.add(hearts);
        game_panel.add(submit_button);
        game_panel.add(user_input);
        game_panel.add(game_message_text);
        game_panel.add(back_button);
        game_panel.add(gameTitle);
        container.add(game_panel);
    }
    private String _hearts(int howManyTrials) {
        String hearts_string = "";
        for(int i = 0; i < howManyTrials(); i++)
        {
            hearts_string += "♥";
        }
        return hearts_string;
    }
}

