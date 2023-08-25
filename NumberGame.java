import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGameGUI extends JFrame {
    private JLabel promptLabel1;
    private JLabel promptLabel2;
    // private JLabel promptLabel3;
    private JLabel promptLabel4;
    private JPanel spacePanel;
    private JTextField inputField;
    private JButton guessButton;
    private int randomNum;
    private int attempts;
    String[] lowmessages = {
            "Almost there! Your guess is a bit too low, keep going!",
            "Not quite there! Your guess is too low, try again.",
            "Keep going! Your guess is lower than the target.",
    };
    String[] highmessages = {
            "Getting close! Your guess is a bit too high, keep trying!",
            "Getting warmer! Your guess is too high, try again.",
            "Keep trying! Your guess is higher than the target."
    };

    public NumberGameGUI() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Initialize range
        int minRange = 1;
        int maxRange = 100;

        // Create the object of Random class
        Random random = new Random();
        randomNum = random.nextInt(maxRange - minRange + 1) + minRange;
        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(20, 20));
        JLabel promptLabel1 = new JLabel("/t/t/tWelcome to Number Guessing Game!");
        JLabel spacelabel1 = new JLabel(" ");
        JLabel promptLabel2 = new JLabel("\t\t\t\t You have 5 chances to guess correct number");
        JLabel spacelabel2 = new JLabel(" ");
        JLabel promptLabel3 = new JLabel(" /tI have picked the Random Number, Now It's your turn to guess!");
        JLabel spacelabel3 = new JLabel(" ");
        JLabel promptLabel4 = new JLabel("/t/t/t/t Enter any Number between 1-100  ");
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputField = new JTextField(20);
        inputPanel.add(inputField);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guessButton = new JButton("check");
        buttonPanel.add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guessNumber = Integer.parseInt(inputField.getText());
                attempts++;

                if (guessNumber == randomNum) {
                    JOptionPane.showMessageDialog(null,
                            "Correct! You guessed the number in " + attempts + " attempts.");
                    int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again",
                            JOptionPane.YES_NO_OPTION);
                    if (playAgain == JOptionPane.YES_OPTION) {
                        // Generate a new random number and reset the attempts
                        randomNum = random.nextInt(maxRange - minRange + 1) + minRange;
                        attempts = 0;
                    } else {
                        System.exit(0); // Exit the application
                    }
                } else if (guessNumber < randomNum) {
                    int index = random.nextInt(lowmessages.length);
                    JOptionPane.showMessageDialog(null, lowmessages[index]);
                } else {
                    int indexe = random.nextInt(highmessages.length);
                    JOptionPane.showMessageDialog(null, highmessages[indexe]);
                }
                if (attempts == 5) {
                    JOptionPane.showMessageDialog(null,
                            "OOPs! You have FAILED,5 Attempts complete! Better luck next time.");
                    System.exit(0);
                }
                inputField.setText("");
            }
        });

        add(promptLabel1);
        add(spacelabel1);
        add(promptLabel2);
        add(spacelabel2);
        add(promptLabel3);
        add(spacelabel3);
        add(promptLabel4);
        add(inputPanel);
        add(buttonPanel);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGameGUI().setVisible(true);
            }
        });
    }
}
