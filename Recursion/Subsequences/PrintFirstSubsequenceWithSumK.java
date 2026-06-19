import java.util.*;

class Scratch {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int target = 5;

        printFirstSubsequence(arr, new ArrayList<Integer>(), 0, 0, target);
    }

    public static boolean printFirstSubsequence(int[] arr, ArrayList<Integer> list, int index, int sum, int target) {
        if(index >= arr.length) { return false; }

        list.add(arr[index]);
        if(sum + arr[index] == target) {
            System.out.println(list);
            return true;
        }
        boolean printed = printFirstSubsequence(arr, list, index + 1, sum + arr[index], target);
        if(printed) { return printed; }
        list.removeLast();
        return printFirstSubsequence(arr, list, index + 1, sum, target);
    }
}