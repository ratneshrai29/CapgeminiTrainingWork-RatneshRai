class sum extends Thread {
    int [] m1row;
    int [] m2row;
    int [] m3row;
    sum(int [] m1row, int [] m2row, int [] m3row){
        this.m1row = m1row;
        this.m2row = m2row;
        this.m3row = m3row;

    }
    public void run(){
        for(int i =0;i<m1row.length;i++){
           m3row[i] =  m1row[i] + m2row[i];
        }
    }
}
public class MatrixSum {
    public static void main(String[] args) throws InterruptedException {
        int [][] m1 = {{1,2,3,4},{5,6,7,8},{2,3,5,7},{3,4,5,6},{2,4,6,8}};
        int [][] m2 = {{1,2,3,4},{5,6,7,8},{2,3,5,7},{3,4,5,6},{2,4,6,8}};

        sum[] threads = new sum[m1.length];
        int [][] m3 = new int[5][4];
        for(int i =0;i< m1.length;i++){
            threads[i] = new sum(m1[i],m2[i],m3[i]);
            threads[i].start();
        }
        for(int i =0;i<threads.length;i++){
            threads[i].join();
        }
        System.out.println("Sum of Matrix : ");
        for(int i =0;i<m3.length;i++){
            for(int j =0;j<m3[0].length;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }



    }
}
