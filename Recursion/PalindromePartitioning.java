import java.util.*;

class Scratch {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.partition("aabb"));
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generatePartitions(ans, s, new ArrayList<String>(), 0);
        return ans;
    }

    void generatePartitions(List<List<String>> ans, String s, ArrayList<String> list, int startIndex) {
        if(startIndex == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = startIndex; i < s.length();i++) {
            if(isPalindrome(s, startIndex, i)) {
                list.add(s.substring(startIndex, i + 1));
                generatePartitions(ans, s, list, i + 1);
                list.removeLast();
            }
        }
    }

    boolean isPalindrome(String s, int startIndex, int endIndex) {
        while(startIndex <= endIndex) {
            if(s.charAt(startIndex++) != s.charAt(endIndex--)) return false;
        }
        return true;
    }
}