import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int n = arr.length;

        // 28. Index of a specified element
        int key = 50;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        System.out.println("28. Index of " + key + " = " + index);

        // 29. Swap two given indexed elements
        int i1 = 1, i2 = 5;
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
        System.out.println("29. After swap: " + Arrays.toString(arr));

        // 30. Reverse entire array
        reverse(arr, 0, n - 1);
        System.out.println("30. Reverse array: " + Arrays.toString(arr));

//         31. Reverse first half
        reverse(arr, 0, n / 2 - 1);
        System.out.println("31. Reverse first half: " + Arrays.toString(arr));

//         32. Reverse last half
        reverse(arr, n / 2, n - 1);
        System.out.println("32. Reverse last half: " + Arrays.toString(arr));

//         33. Reverse only even indexed elements
        reverseEvenIndex(arr);
        System.out.println("33. Reverse even index: " + Arrays.toString(arr));

//         34. Reverse only odd indexed elements
        reverseOddIndex(arr);
        System.out.println("34. Reverse odd index: " + Arrays.toString(arr));

//         35. Swap odd index with next even index
        for (int i = 1; i < n - 1; i += 2) {
            int t = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = t;
        }
        System.out.println("35. Swap odd with next even: " + Arrays.toString(arr));

//         36–38. Right shift by 1,2,3
        rightShift(arr, 1);
        System.out.println("36. Right shift by 1: " + Arrays.toString(arr));

        rightShift(arr, 2);
        System.out.println("37. Right shift by 2: " + Arrays.toString(arr));
//
        rightShift(arr, 3);
        System.out.println("38. Right shift by 3: " + Arrays.toString(arr));

        // 39–41. Left shift by 1,2,3
        leftShift(arr, 1);
        System.out.println("39. Left shift by 1: " + Arrays.toString(arr));

        leftShift(arr, 2);
        System.out.println("40. Left shift by 2: " + Arrays.toString(arr));

        leftShift(arr, 3);
        System.out.println("41. Left shift by 3: " + Arrays.toString(arr));

        // 42–44. Right rotate by 1,2,3
        rightRotate(arr, 1);
        System.out.println("42. Right rotate by 1: " + Arrays.toString(arr));

        rightRotate(arr, 2);
        System.out.println("43. Right rotate by 2: " + Arrays.toString(arr));

        rightRotate(arr, 3);
        System.out.println("44. Right rotate by 3: " + Arrays.toString(arr));

        // 45. Left rotate by 1
        leftRotate(arr, 1);
        System.out.println("45. Left rotate by 1: " + Arrays.toString(arr));
    }

    // ---------- Helper Methods ----------

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void reverseEvenIndex(int[] arr) {
        int left = 0;
        int right = (arr.length % 2 == 0) ? arr.length - 2 : arr.length - 1;
        while (left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left += 2;
            right -= 2;
        }
    }

    static void reverseOddIndex(int[] arr) {
        int left = 1;
        int right = (arr.length % 2 == 0) ? arr.length - 1 : arr.length - 2;
        while (left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left += 2;
            right -= 2;
        }
    }

    static void rightShift(int[] arr, int k) {
        k %= arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = 0;
        }
    }


    static void leftShift(int[] arr, int k) {
        k %= arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = 0;
        }
    }

    static void rightRotate(int[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    static void leftRotate(int[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
}
