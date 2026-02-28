import java.util.*;

public class class6 {
    public static void main(String[] args) {
        // INT 2D ARRAY
//        int[][] arr = new int[3][4];
//        int num =1;
//        for(int i=0;i<arr.length;i++){
//            for(int j =0;j<arr[0].length;j++){
//                arr[i][j] = num++;
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            for(int j =0;j<arr[0].length;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        // STRING 2D ARRAY
//        String[][] arr1 = new String[3][4];
//        char num1 ='a';
//        for(int i=0;i<arr1.length;i++){
//            for(int j =0;j<arr1[0].length;j++){
//                arr1[i][j] = String.valueOf(num1++);
//            }
//        }
//        for(int i=0;i<arr1.length;i++){
//            for(int j =0;j<arr1[0].length;j++){
//                System.out.print(arr1[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        // CHAR 2D ARRAY
//        char[][] arr2 = new char[3][4];
//        char num2 ='f';
//        for(int i=0;i<arr2.length;i++){
//            for(int j =0;j<arr2[0].length;j++){
//                arr2[i][j] = num2++;
//            }
//        }
//        for(int i=0;i<arr2.length;i++){
//            for(int j =0;j<arr2[0].length;j++){
//                System.out.print(arr2[i][j]+" ");
//            }
//            System.out.println();
//        }

        //TRANSPOSE OF MATRIX
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][4];
        int[][] arr1 = new int[3][4];


        int row = arr.length;
        int col = arr[0].length;
        System.out.println("Enter Element: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Element: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        int[][] arrT = new int[col][row];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrT[j][i] = arr[i][j];
            }
        }

        System.out.println("Original Matrix");
        printmatrix(arr);

        System.out.println("Transpose Matrix");
        printmatrix(arrT);

        addmatrix(arr, arr1);
    }

    public static void printmatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ADDITION OF MATRIX
    public static void addmatrix(int[][] arr, int[][] arr1) {
        int row = arr.length;
        int col = arr[0].length;

        int[][] sumarr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumarr[i][j] = arr[i][j] + arr1[i][j];
            }
        }
        System.out.println("Addition of Matrix");
        printmatrix(sumarr);
    }
}
