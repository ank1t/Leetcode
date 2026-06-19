import java.util.*;

class PrintAllPermutations1 {
    public static void main(String[] args) {
        var arr = new int[] {1,2,3};
        var map = new boolean[] {true, true, true};

        var ans = new ArrayList<ArrayList<Integer>>();
        printAllPermutations(arr, map, new ArrayList<Integer>(), ans);

        System.out.println(ans);
    }

    public static void printAllPermutations(int[] arr, boolean[] map, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if(list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!map[i]) continue;

            list.add(arr[i]);
            map[i] = false;
            printAllPermutations(arr, map, list, ans);
            list.removeLast();
            map[i] = true;
        }
    }
}