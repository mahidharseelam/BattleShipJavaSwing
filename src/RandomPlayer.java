import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomPlayer extends JFrame {
    private JPanel panel;
    public JButton[][] buttons;
    private final int SIZE = 10;
    private GridLayout experimentLayout;
    public String[][] gridArrayBattleShip = new String[10][10];
    private static int count = 0;
    private final String SINGLE_SHIP_VALUE = "1";
    private final String DOUBLE_SHIP_VALUE = "2";
    private final String TRIPLE_SHIP_VALUE = "3";
    Random rand = new Random();


    // battle ship class constructor for class
    public RandomPlayer() {
        super("RandomPlayer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLocation(450, 300);
        experimentLayout = new GridLayout(SIZE, SIZE);
        panel = new JPanel();
        panel.setLayout(experimentLayout);
        buttons = new JButton[SIZE][SIZE];
        addButtons(panel);

        add(panel);
        setVisible(true);

        addSingleShip();
        addSingleShip();
        addHorizontalDoubleShip();
        addVerticalDoubleShip();
        addHorizontalTripleShip();
        addVerticalTripleShip();

    }

    public void addButtons(JPanel panel) {
        int k;
        int j;
        for (k = 0; k < SIZE; k++) {
            for (j = 0; j < SIZE; j++) {
                buttons[k][j] = new JButton();
                //buttons[k][j].setActionCommand(String.valueOf(k) + String.valueOf(j));
                if (gridArrayBattleShip[k][j] == null) {
                    buttons[k][j].setBackground(Color.white);
                }
                panel.add(buttons[k][j]);
            }
        }
    }



    public void addSingleShip() {
        while (true) {
            int randomPositionX = rand.nextInt(10);
            int randomPositionY = rand.nextInt(10);
            if (gridArrayBattleShip[randomPositionX][randomPositionY] == null) {
                gridArrayBattleShip[randomPositionX][randomPositionY] = SINGLE_SHIP_VALUE;
                System.out.println(gridArrayBattleShip[randomPositionX][randomPositionY]);
                buttons[randomPositionX][randomPositionY].setBackground(Color.red);
                return;
            } else {
                continue;
            }
        }
    }

    public void addVerticalDoubleShip() {
        // while (true) {
        int randomPositionX = rand.nextInt(10);
        int randomPositionY = rand.nextInt(9);
//            for (int i = randomPositionY; i < randomPositionY+2; i++) {
//                if (gridArrayBattleShip[randomPositionX][i] == null) {
//                    continue;
//                } else {
//                    break;
//                }
//            }
        for (int i = randomPositionY; i < randomPositionY + 2; i++) {
            gridArrayBattleShip[randomPositionX][i] = DOUBLE_SHIP_VALUE;
            buttons[randomPositionX][i].setBackground(Color.BLUE);
        }
        // }
    }

    public void addHorizontalDoubleShip() {
        int randomPositionX = rand.nextInt(9);
        int randomPositionY = rand.nextInt(10);
        for (int i = randomPositionX; i < randomPositionX + 2; i++) {
            gridArrayBattleShip[i][randomPositionY] = DOUBLE_SHIP_VALUE;
            buttons[i][randomPositionY].setBackground(Color.BLUE);
        }
    }

    public void addVerticalTripleShip() {
        int randomPositionX = rand.nextInt(10);
        int randomPositionY = rand.nextInt(8);
        for (int i = randomPositionY; i < randomPositionY + 3; i++) {
            gridArrayBattleShip[randomPositionX][i] = TRIPLE_SHIP_VALUE;
            buttons[randomPositionX][i].setBackground(Color.green);
        }
    }

    public void addHorizontalTripleShip() {
        int randomPositionX = rand.nextInt(8);
        int randomPositionY = rand.nextInt(10);
        for (int i = randomPositionX; i < randomPositionX + 3; i++) {
            gridArrayBattleShip[i][randomPositionY] = TRIPLE_SHIP_VALUE;
            buttons[i][randomPositionY].setBackground(Color.green);
        }
    }

    public void print() {
        count++;
        System.out.println("computer got point " + count);
        int counter = 0;
        for (int k = 0; k < SIZE; k++) {
            for (int j = 0; j < SIZE; j++) {
                if (gridArrayBattleShip[k][j] == null || gridArrayBattleShip[k][j].equals("clicked")) {
                    counter++;
                }
            }
        }
        if (counter == 100) {
            System.out.println("COMPUTER WON GAME!!!!");
        }
    }

    public void randomClick() {
        while (true) {
            int randomPositionX = rand.nextInt(10);
            int randomPositionY = rand.nextInt(10);

            if (gridArrayBattleShip[randomPositionX][randomPositionY] == null){
                buttons[randomPositionX][randomPositionY].setText("X");
                gridArrayBattleShip[randomPositionX][randomPositionY] = "clicked";
                break;
            }
             else if(gridArrayBattleShip[randomPositionX][randomPositionY].equals("1")
                    || gridArrayBattleShip[randomPositionX][randomPositionY].equals("2")
                    || gridArrayBattleShip[randomPositionX][randomPositionY].equals("3")) {
                gridArrayBattleShip[randomPositionX][randomPositionY] = "clicked";
                buttons[randomPositionX][randomPositionY].setText("X");
                print();
                break;
            } else {
                continue;
            }
        }
    }
}