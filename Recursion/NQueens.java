import java.util.*;

class NQueens {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<String> grid = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            grid.add(".".repeat(n));
        }

        var ans = new ArrayList<ArrayList<String>>();
        var leftRow = new int[n];
        var upperDiagonal = new int[2 * n - 1];
        var lowerDiagonal = new int[2 * n - 1];

        findNQueenArrangement(grid, 0, ans, leftRow, upperDiagonal, lowerDiagonal);

        System.out.println(ans.size());
    }

    private static void findNQueenArrangement(ArrayList<String> grid, int col, ArrayList<ArrayList<String>> ans,
                                              int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if(col == grid.size()) {
            ans.add(new ArrayList<>(grid));
            return;
        }

        for(int i = 0;i < grid.size();i++) {
            if(leftRow[i] != 1 && lowerDiagonal[i + col] != 1 && upperDiagonal[grid.size() - 1 + col - i] != 1) {
                leftRow[i] = 1;
                lowerDiagonal[i + col] = 1;
                upperDiagonal[grid.size() - 1 + col - i] = 1;
                var temp1 = grid.get(i).toCharArray();
                temp1[col] = 'Q';
                grid.set(i, new String(temp1));

                findNQueenArrangement(grid,col + 1, ans, leftRow, upperDiagonal, lowerDiagonal);

                leftRow[i] = 0;
                lowerDiagonal[i + col] = 0;
                upperDiagonal[grid.size() - 1 + col - i] = 0;
                var temp2 = grid.get(i).toCharArray();
                temp2[col] = '.';
                grid.set(i, new String(temp2));
            }
        }
    }
}