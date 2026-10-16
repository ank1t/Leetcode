
/*
    https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
 */
class Solution {
    public int countPartitions(int[] arr, int diff) {
        int total = 0;
        for(num: arr) total += num;
        if(total - diff < 0 || (total - diff) % 2 == 1) return 0;

        return recursion(arr, 0, (t - d)/2);
    }

    int recursion(int[] arr, int index, int target) {
        if(index == arr.length) {
            if(target == 0) return 1;
            return 0;
        }

        int pick = 0;
        if(arr[index] <= target) pick = recursion(arr, index + 1, target - arr[index]);
        int notPick = recursion(arr, index + 1, target);

        return pick + notPick;
    }

    /*
        int n = arr.length;

		int total = 0;
		for (int num: arr)
			total += num;

        Since numbers are given to be non-negative, we can just have the second condition
		if (total - diff < 0 || (total - diff) % 2 == 1)
			return 0;
		int target = (total - diff)/2;

        OR
        if (total + diff < diff || (total + diff) % 2 == 1)
			return 0;
		int target = (total + diff)/2;

		int[][] dp = new int[n][target + 1];
		for(int[] row: dp) Arrays.fill(row, -1);

		return recursion(arr, 0, target, dp);
     */
    int memoization(int[] arr, int index, int target, int[][] dp) {
        if (index == arr.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int pick = 0;
        if (arr[index] <= target)
            pick = recursion(arr, index + 1, target - arr[index], dp);
        int notPick = recursion(arr, index + 1, target, dp);

        return dp[index][target] = pick + notPick;
    }

    int tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= k) dp[0][arr[0]] = 1;

        for(int index = 1;index < n;index++) {
            for(int target = 0;target <= k;target++) {
                int pick = 0;
                if (arr[index] <= target)
                    pick = dp[index - 1][target - arr[index]];
                int notPick = dp[index - 1][target];

                dp[index][target] = pick + notPick;
            }
        }

        return dp[n - 1][k];
    }

    int spaceOptimization(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k + 1];

        if (arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (arr[0] != 0 && arr[0] <= k)
            prev[arr[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] cur = new int[k + 1];
            for (int target = 0; target <= k; target++) {
                int pick = 0;
                if (arr[index] <= target)
                    pick = prev[target - arr[index]];
                int notPick = prev[target];

                cur[target] = pick + notPick;
            }
            prev = cur;
        }

        return prev[k];
    }
}

class Scratch {
    public static void main(String[] args) {
        
    }
}