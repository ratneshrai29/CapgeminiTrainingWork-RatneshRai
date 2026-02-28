public class class4 {
    public static void main(String[] args) {
        int [] arr1 = returnArray();

//        arr1--> 0X1
        for(int i : arr1){
            System.out.println(i);
        }

    }
    public static int[] returnArray(){                 // RETURNING ARRAY
        int[] arr ={1,2,3};
        return arr; //0X1

    }
}
