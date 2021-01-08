import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BattleShip extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton[][] buttons;
    private final int SIZE = 10;
    private static int count = 0;
    private GridLayout experimentLayout;
    public String[][] gridArrayBattleShip = new String[10][10];
    private final String SINGLE_SHIP_VALUE = "1";
    private final String DOUBLE_SHIP_VALUE = "2";
    private final String TRIPLE_SHIP_VALUE = "3";
    Random rand = new Random();
    RandomPlayer randomPlayer = new RandomPlayer();


    // battle ship class constructor for class
    public BattleShip() {
        super("BattleShip");
        Layout();
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
                buttons[k][j].addActionListener(this);
                buttons[k][j].setActionCommand(String.valueOf(k) + String.valueOf(j));
                panel.add(buttons[k][j]);
            }
        }
        //addSingleShip(k,j);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        System.out.println(cmd);
        int k;
        int j;
        for (k = 0; k < SIZE; k++) {
            for (j = 0; j < SIZE; j++) {

                if (cmd.equals(String.valueOf(k) + String.valueOf(j))) {

                    if (gridArrayBattleShip[k][j] == null) {
                        buttons[k][j].setBackground(Color.blue);
                        gridArrayBattleShip[k][j] = "clicked";
                        // System.out.println("clicked");
                    } else if (gridArrayBattleShip[k][j].equals(DOUBLE_SHIP_VALUE)) {
                        buttons[k][j].setBackground(Color.red);
                        gridArrayBattleShip[k][j] = "clicked";
                        buttons[k][j].setText("X");
                        print();
                    } else if (gridArrayBattleShip[k][j].equals(TRIPLE_SHIP_VALUE)) {
                        buttons[k][j].setBackground(Color.red);
                        gridArrayBattleShip[k][j] = "clicked";
                        buttons[k][j].setText("X");
                        print();
                    } else if (gridArrayBattleShip[k][j].equals(SINGLE_SHIP_VALUE)) {
                        // ((JButton) ae.getSource()).setBackground(Color.blue);
                        buttons[k][j].setText("X");
                        gridArrayBattleShip[k][j] = "clicked";
                        buttons[k][j].setBackground(Color.red);
                        print();
                    }

                }
            }
        }
        randomPlayer.randomClick();
    }

    public void addSingleShip() {

            int randomPositionX = rand.nextInt(10);
            int randomPositionY = rand.nextInt(10);
                gridArrayBattleShip[randomPositionX][randomPositionY] = SINGLE_SHIP_VALUE;
                //System.out.println(gridArrayBattleShip[randomPositionX][randomPositionY]);
    }

    public void addVerticalDoubleShip() {
        int randomPositionX = rand.nextInt(10);
        int randomPositionY = rand.nextInt(9);
        if (gridArrayBattleShip[randomPositionX][randomPositionY] == null) {
            for (int i = randomPositionY; i < randomPositionY + 2; i++) {
                gridArrayBattleShip[randomPositionX][i] = DOUBLE_SHIP_VALUE;
            }
        }
    }

    public void addHorizontalDoubleShip() {
        int randomPositionX = rand.nextInt(9);
        int randomPositionY = rand.nextInt(10);
        if (gridArrayBattleShip[randomPositionX][randomPositionY] == null) {
            for (int i = randomPositionX; i < randomPositionX + 2; i++) {
                gridArrayBattleShip[i][randomPositionY] = DOUBLE_SHIP_VALUE;
                //buttons[i][randomPositionY].setBackground(Color.BLUE);
            }
        }
    }

    public void addVerticalTripleShip() {
        int randomPositionX = rand.nextInt(10);
        int randomPositionY = rand.nextInt(8);
        for (int i = randomPositionY; i < randomPositionY + 3; i++) {
            gridArrayBattleShip[randomPositionX][i] = TRIPLE_SHIP_VALUE;
            // buttons[randomPositionX][i].setBackground(Color.green);
        }
    }

    public void addHorizontalTripleShip() {
        int randomPositionX = rand.nextInt(8);
        int randomPositionY = rand.nextInt(10);
        for (int i = randomPositionX; i < randomPositionX + 3; i++) {
            gridArrayBattleShip[i][randomPositionY] = TRIPLE_SHIP_VALUE;
            // buttons[i][randomPositionY].setBackground(Color.green);
        }
    }

    public void print() {
        count++;
        System.out.println("Player got point " + count);
        int counter = 0;
        for (int k = 0; k < SIZE; k++) {
            for (int j = 0; j < SIZE; j++) {
                if (gridArrayBattleShip[k][j] == null || gridArrayBattleShip[k][j].equals("clicked")) {
                    counter++;
                }
            }
        }
        if (counter == 100) {
            System.out.println("PLAYER WON GAME!!!!");

        }
    }

    public void Layout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLocation(950, 300);
        experimentLayout = new GridLayout(SIZE, SIZE);
        panel = new JPanel();
        panel.setLayout(experimentLayout);
        buttons = new JButton[SIZE][SIZE];
        addButtons(panel);

        add(panel);
    }
}