import java.util.*;

class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        reverseArray(arr, 0);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr, int n) {
        if(n >= arr.length/2) { return; }

        //Swap elements
        var temp = arr[n];
        arr[n] = arr[arr.length - 1 - n];
        arr[arr.length - 1 - n] = temp;

        reverseArray(arr, n + 1);
    }
}