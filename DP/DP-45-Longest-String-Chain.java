import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n == 1) return 1;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(isPredecessor(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if(maxLen < dp[i]) maxLen = dp[i];
        }
        return maxLen;
    }

    boolean isPredecessor(String s1, String s2) {
        //s1 is the longer string
        int s1Len = s1.length();
        int s2Len = s2.length();

        if(s2Len + 1 != s1Len) return false;
        int p1 = 0;
        int p2 = 0;
        int numDiffChars = 0;

        while(p1 < s1Len && numDiffChars <= 1) {
            if(p2 < s2Len && s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
                numDiffChars++;
            }
        }
        return numDiffChars == 1;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));;
    }
}