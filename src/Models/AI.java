package Models;

import java.util.ArrayList;
import java.util.List;

public class AI {
    
    public static int utility(Board b, Player p){
        
        for(int i=0; i< 3;i++){
            int hsum = 0;
            int vsum = 0;
            for(int j = 0; j< 3; j++){
                hsum += b.grille[i][j];
                vsum += b.grille[j][i];
                if(vsum == 3*p.value || hsum == 3*p.value){
                    return 1;
                }   
            }
        }
        int asum = 0;
        int dsum = 0;
        for(int i = 0; i<3; i++){
            asum += b.grille[i][i];
            dsum += b.grille[2-i][2-i];
            System.out.println(asum);
            if(asum == 3*p.value || dsum == 3*p.value){
                return 1;
            }
        }
        return 0;
    }

    public static List<Cell> findEmptyCells(Board b){
        List<Cell> cells = new ArrayList<Cell>();
        for(int i = 0; i<3; i++){
            for(int j =0;j<3;j++){
                if(b.grille[i][j] == 0){
                    cells.add(new Cell(i,j));
                }
            }
        }
        return cells;
    }

    public void play(Board b, Player p){
        List<Cell> emptyCells = findEmptyCells(b);
        Cell bestMove = null;
        int score;
        for(Cell cell : emptyCells){
            score = minmax(b, cell, p);
        }
    }

    public int minmax(Board board, Cell c, Player p){
        board.grille[c.line][c.column] = p.value;
        int score = utility(board, p); 
        List<Cell> freeCells = findEmptyCells(board);
        if(score != 0){
            return score;
        }else if(freeCells.isEmpty()){
            return 0;
        }else{
            Cell best = null;
            if(p == board.player){
                int max = 0;
                for (Cell cell : freeCells) {
                    int s = minmax(board, cell, p);
                    if(s > max){
                        score = s;
                        best = cell;
                    }
                }
            }else{
                int min = 0;
                for (Cell cell : freeCells) {
                    int s = minmax(board, cell, p);
                    if(s < min){
                        score = s;
                        best = cell;
                    }
                }
            }
        }   
        //return le meilleur coup
        board.grille[c.line][c.column] = 0;
        return score;
    }
}