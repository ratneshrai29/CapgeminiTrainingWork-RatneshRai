import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------- READ MATRIX ----------
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // ---------- PRINT MATRIX ----------
        System.out.println("Matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        // ---------- SUM OF ALL ELEMENTS ----------
        int totalSum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                totalSum += mat[i][j];
        System.out.println("Sum of all elements = " + totalSum);

        // ---------- SUM OF EACH ROW ----------
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++)
                rowSum += mat[i][j];
            System.out.println("Sum of row " + i + " = " + rowSum);
        }

        // ---------- SUM OF EACH COLUMN ----------
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < m; i++)
                colSum += mat[i][j];
            System.out.println("Sum of column " + j + " = " + colSum);
        }

        // ---------- MAX & MIN ELEMENT ----------
        int max = mat[0][0];
        int min = mat[0][0];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > max) max = mat[i][j];
                if (mat[i][j] < min) min = mat[i][j];
            }

        System.out.println("\nMaximum element = " + max);
        System.out.println("Minimum element = " + min);

        // ---------- COUNT EVEN & ODD ----------
        int even = 0, odd = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 == 0)
                    even++;
                else
                    odd++;
            }

        System.out.println("\nEven count = " + even);
        System.out.println("Odd count = " + odd);

        // ---------- SEARCH ELEMENT ----------
        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == key) {
                    System.out.println("Element found at (" + i + "," + j + ")");
                    found = true;
                }

        if (!found)
            System.out.println("Element not found");

        // ---------- REVERSE MATRIX ----------
        System.out.println("\nMatrix in reverse order:");
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        // ---------- COUNT ZERO ELEMENTS ----------
        int zeroCount = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0)
                    zeroCount++;

        System.out.println("\nTotal zero elements = " + zeroCount);

        // ---------- TRACE OF SQUARE MATRIX ----------
        if (m == n) {
            int trace = 0;
            for (int i = 0; i < m; i++)
                trace += mat[i][i];
            System.out.println("Trace = " + trace);
        } else {
            System.out.println("Trace not possible (not a square matrix)");
        }

        // ---------- TRANSPOSE ----------
        System.out.println("\nTranspose of matrix:");
        int[][] transpose = new int[n][m];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transpose[j][i] = mat[i][j];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        // ---------- LARGEST ELEMENT IN EACH ROW ----------
        System.out.println("\nLargest element in each row:");
        for (int i = 0; i < m; i++) {
            int rowMax = mat[i][0];
            for (int j = 1; j < n; j++)
                if (mat[i][j] > rowMax)
                    rowMax = mat[i][j];
            System.out.println("Row " + i + " max = " + rowMax);
        }

        // ---------- SMALLEST ELEMENT IN EACH COLUMN ----------
        System.out.println("\nSmallest element in each column:");
        for (int j = 0; j < n; j++) {
            int colMin = mat[0][j];
            for (int i = 1; i < m; i++)
                if (mat[i][j] < colMin)
                    colMin = mat[i][j];
            System.out.println("Column " + j + " min = " + colMin);
        }

        sc.close();
    }
}

