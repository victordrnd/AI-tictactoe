package Models;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board {
    int[][] grille = { { 1, 0, 0 }, { -1, 0, 1 }, { 0, -1, 0 } };

    public void display() {
        System.out.println(" ___________");
        for (int[] ligne : grille) {
            System.out.println("");
            System.out.print("|");
            for (int value : ligne) {
                if (value > 0) {
                    System.out.print(" X ");
                } else if (value == -1) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.println("\n ___________");
        }
        GridLayout grid = new GridLayout(3,3);
        JFrame frame = new JFrame("Tic tac toe");
        JPanel panel = new JPanel();
        panel.setLayout(grid);
        for (int[] ligne : grille) {
            for (int value : ligne) {
                if (value > 0) {
                    panel.add(createButton(" X "));
                } else if (value == -1) {
                    panel.add(createButton(" 0 "));
                } else {
                    panel.add(createButton("   "));
                }
                
            }
        }
        frame.setContentPane(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }


    public JButton createButton(String value){
        JButton button = new JButton(value);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setBackground(Color.WHITE);
        return button;

    }
}