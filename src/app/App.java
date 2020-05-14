package app;

import Models.Board;
import Models.Player;

public class App {

    //board + coup joué + note
    public static void main(String[] args) throws Exception {
        Board b = new Board();
        Player p1 = new Player('X', 1);
        Player p2 = new Player('O', -1);
        b.display();
    }
}