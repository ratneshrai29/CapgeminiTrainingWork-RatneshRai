import java.util.Random;
import java.util.Scanner;

public class Snakegame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rows = 5;
        int cols = 5;

        char[][] board = new char[rows][cols];

        int snakeRow = 2;
        int snakeCol = 2;

        int foodRow = random.nextInt(rows);
        int foodCol = random.nextInt(cols);

        int score = 0;

        while (true) {

            // Clear board
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = '.';
                }
            }

            // Place snake and food
            board[snakeRow][snakeCol] = 'S';
            board[foodRow][foodCol] = 'F';

            System.out.println("\n--- SNAKE GAME ---");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Score: " + score);
            System.out.println("Move: U D L R | Q to Quit");

            char move = sc.next().toUpperCase().charAt(0);

            switch (move) {
                case 'U': snakeRow--; break;
                case 'D': snakeRow++; break;
                case 'L': snakeCol--; break;
                case 'R': snakeCol++; break;
                case 'Q':
                    System.out.println("Game Over! Final Score: " + score);
                    return;
                default:
                    System.out.println("Invalid Move!");
            }

            // Boundary check
            if (snakeRow < 0 || snakeRow >= rows || snakeCol < 0 || snakeCol >= cols) {
                System.out.println("Snake hit the wall!");
                System.out.println("Game Over! Final Score: " + score);
                break;
            }

            // Food eaten
            if (snakeRow == foodRow && snakeCol == foodCol) {
                score++;
                foodRow = random.nextInt(rows);
                foodCol = random.nextInt(cols);
                System.out.println("Food Eaten!");
            }
        }
    }
}