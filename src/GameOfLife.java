import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameOfLife {
    private int[][] current;
    private static int N = 4;
    public static int getCellState(int row, int col, int[][] current) {
        int liveCount = 0;
        int lastCellIndex = N - 1;
        if (row > 0 && col > 0) {
            liveCount += current[row - 1][col - 1];
        }
        if (row > 0) {
            liveCount += current[row - 1][col];
            if (col < lastCellIndex) {
                liveCount += current[row - 1][col + 1];
            }
        }
        if (col < lastCellIndex) {
            liveCount += current[row][col + 1];
        }
        if (col > 0) {
            liveCount += current[row][col - 1];
            if (row < lastCellIndex) {
                liveCount += current[row + 1][col - 1];
            }
        }
        if (row < lastCellIndex) {
            liveCount += current[row + 1][col];
        }
        if (row < lastCellIndex && col < lastCellIndex) {
            liveCount += current[row + 1][col + 1];
        }

        return liveCount == 2 ? 1 : 0;
    }
    public static int[][] getNextGeneration(int[][] current) {
        int[][] next = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                next[i][j] = getCellState(i, j, current);
                System.out.print(next[i][j] + " ");
            }
            System.out.println();
        }

        return next;
    }
    public GameOfLife() {
        int[][] arr = {
            {0, 0, 0, 0},
            {0, 0, 0, 1},
            {1, 1, 1, 0},
            {0, 0, 0, 0},
        };
        this.current = arr;
    }
   public void play(){
       Scanner sc = new Scanner(System.in);
       String s1 = "";
       while(!s1.equals("exit")){
           System.out.println("print enter to get next generation");
           current = getNextGeneration(current);
           s1 = sc.next();

       }
   }
}
