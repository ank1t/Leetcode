import java.util.*;

class PrintAllSubsequencesRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        printSubsequences(arr, new ArrayList<Integer>(), 0);
    }

    public static void printSubsequences(int[] arr, ArrayList<Integer> list, int index) {
        if(index >= arr.length) { System.out.println(list); return; }

        list.add(arr[index]);
        printSubsequences(arr, list, index + 1);
        list.removeLast();
        printSubsequences(arr, list, index + 1);
    }
}