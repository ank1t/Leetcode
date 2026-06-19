import java.util.*;

class PrintPermutations2 {
    public static void main(String[] args) {
        var arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        var ans = new ArrayList<ArrayList<Integer>>();
        printAllPermutations(0, arr, ans);

        System.out.println(ans);
    }

    public static void printAllPermutations(int index, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans) {
        if(index == arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = index;i < arr.size(); i++) {
            Collections.swap(arr, index, i);
            printAllPermutations(index + 1, arr, ans);
            Collections.swap(arr, index, i);
        }
    }
}