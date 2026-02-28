//public class Main {
//    public static void main(String[] args) {
//        int [] arr = {11,21,31,4,15};
//        int n = arr.length;
////   1.         int sum =0;
////        for(int i= 0;i<n;i++){
////             sum += arr[i];
////        }
////        System.out.println(sum);
//
////   2.     int min =arr[0];
////        for(int i =1;i<n;i++){
////            if(arr[i]<min){
////                min = arr[i];
////            }
////        }
////        System.out.println(min);
//
////    3.    int max = -1;
////        for(int i =0;i<n;i++){
////            if(arr[i]> max){
////                max = arr[i];
////            }
////        }
////        System.out.println(max);
//
////    4.    int secondmax = -1;
////       for(int i=0;i<n;i++){
////           if(arr[i] > secondmax && arr[i]!=max){
////               secondmax = arr[i];
////           }
////        }
////        System.out.println(secondmax);
//    }
//}

public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 5, 8, 30, 15, 25, 40};
        int n = arr.length;

        // 1. Sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i];
        System.out.println("1. Sum = " + sum);

        // 2. Min element
        int min = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] < min) min = arr[i];
        System.out.println("2. Min = " + min);

        // 3. Max element
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max) max = arr[i];
        System.out.println("3. Max = " + max);

        // 4. 2nd Max element
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                secondMax = arr[i];
            }
        }
        System.out.println("4. 2nd Max = " + secondMax);

        // 6. Average of array
        System.out.println("6. Average = " + (sum / (double) n));

        // 7. Sum of even indexed elements
        int evenIndexSum = 0;
        for (int i = 0; i < n; i += 2) evenIndexSum += arr[i];
        System.out.println("7. Even index sum = " + evenIndexSum);

        // 8. Sum of odd indexed elements
        int oddIndexSum = 0;
        for (int i = 1; i < n; i += 2) oddIndexSum += arr[i];
        System.out.println("8. Odd index sum = " + oddIndexSum);

        // 9. Min from even indexed elements
        int minEvenIndex = arr[0];
        for (int i = 2; i < n; i += 2)
            if (arr[i] < minEvenIndex) minEvenIndex = arr[i];
        System.out.println("9. Min even index = " + minEvenIndex);

        // 10. Max from odd indexed elements
        int maxOddIndex = Integer.MIN_VALUE;
        for (int i = 1; i < n; i += 2)
            if (arr[i] > maxOddIndex) maxOddIndex = arr[i];
        System.out.println("10. Max odd index = " + maxOddIndex);

        // 11. Avg of even indexed elements
        int evenCount = (n + 1) / 2;
        System.out.println("11. Avg even index = " + (evenIndexSum / (double) evenCount));

        // 12. Avg of odd indexed elements
        int oddCount = n / 2;
        System.out.println("12. Avg odd index = " + (oddIndexSum / (double) oddCount));

        int mid = n / 2;

        // 13. Sum of first half
        int firstHalfSum = 0;
        for (int i = 0; i < mid; i++) firstHalfSum += arr[i];
        System.out.println("13. First half sum = " + firstHalfSum);

        // 14. Sum of second half
        int secondHalfSum = 0;
        for (int i = mid; i < n; i++) secondHalfSum += arr[i];
        System.out.println("14. Second half sum = " + secondHalfSum);

        // 15. Min from first half
        int minFirstHalf = arr[0];
        for (int i = 1; i < mid; i++)
            if (arr[i] < minFirstHalf) minFirstHalf = arr[i];
        System.out.println("15. Min first half = " + minFirstHalf);

        // 16. Min from second half
        int minSecondHalf = arr[mid];
        for (int i = mid + 1; i < n; i++)
            if (arr[i] < minSecondHalf) minSecondHalf = arr[i];
        System.out.println("16. Min second half = " + minSecondHalf);

        // 17. Max from first half
        int maxFirstHalf = arr[0];
        for (int i = 1; i < mid; i++)
            if (arr[i] > maxFirstHalf) maxFirstHalf = arr[i];
        System.out.println("17. Max first half = " + maxFirstHalf);

        // 18. Max from second half
        int maxSecondHalf = arr[mid];
        for (int i = mid + 1; i < n; i++)
            if (arr[i] > maxSecondHalf) maxSecondHalf = arr[i];
        System.out.println("18. Max second half = " + maxSecondHalf);

        // 19. Avg of first half
        System.out.println("19. Avg first half = " + (firstHalfSum / (double) mid));

        // 20. Avg of second half
        System.out.println("20. Avg second half = " + (secondHalfSum / (double) (n - mid)));

        // 21. Read array in reverse
        System.out.print("21. Reverse array: ");
        for (int i = n - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();

        // 22. First half in reverse
        System.out.print("22. First half reverse: ");
        for (int i = mid - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();

        // 23. Second half in reverse
        System.out.print("23. Second half reverse: ");
        for (int i = n - 1; i >= mid; i--) System.out.print(arr[i] + " ");
        System.out.println();

        // 24. Only even indexed elements
        System.out.print("24. Even indexed elements: ");
        for (int i = 0; i < n; i += 2) System.out.print(arr[i] + " ");
        System.out.println();

        // 25. Even indexed elements in reverse
        System.out.print("25. Even indexed reverse: ");
        for (int i = (n % 2 == 0 ? n - 2 : n - 1); i >= 0; i -= 2)
            System.out.print(arr[i] + " ");
        System.out.println();

        // 26. Only odd indexed elements
        System.out.print("26. Odd indexed elements: ");
        for(int i =1; i<n; i+=2) System.out.print(arr[i]+" ");
        System.out.println();

        // 27. Odd indexed elements in reverse
        System.out.print("27. Odd indexed reverse: ");
        for(int i = (n % 2 == 0 ? n-1 : n-2); i>=0; i-=2)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}

