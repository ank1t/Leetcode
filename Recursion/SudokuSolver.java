import java.util.Arrays;

/*
 Sudoku Solver – Time & Space Complexity Explained! 🔥

See at first everyone would say => 9^81
But if considered only unique solution exists then:-

👉 In every Sudoku problem statement, it is guaranteed that the puzzle has a unique solution.
👉 And from research we know that a valid unique Sudoku needs at least 17 prefilled cells.
👉 That leaves us with 64 empty cells (since the board has 81 cells total).

⏳ Time Complexity

At each empty cell, we may try up to 9 possible digits → branching factor = 9.
Thus, the recursion tree in the worst case can be:

                                                       O(9^64)

But we also need to account for the cost of validity checking (row + col + box).
Here we get two possible cases depending on implementation:

 Case 1 (Naive check):
Each validity check scans up to 27 cells (9 in row + 9 in column + 9 in box).
So, per placement cost = 27.
Final TC = O(9^64 × 27)

Case 2 (Striver's Way):
We can reduce checking cost to just 9 operations (constant-time lookups for row/col/box).
Final TC = O(9^64 × 9)
💾 Space Complexity
Recursion depth = number of empty cells = 64 → O(64) ≈ O(N²).
✅ Overall SC = O(N²).

I think interviewer will be impressed from this much explanation!!
Like if it helps!!
 */
class SudokuSolver {
    public static void main(String[] args) {
        char[][] grid = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        sudokuSolver(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    private static void sudokuSolver(char [][] grid) {
        solve(grid);
    }

    private static boolean solve(char[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '.') {
                    for(int num = 1;num < 10;num++) {
                        if(canPlaceAt(num, row, col, grid)) {
                            grid[row][col] = (char)(num + '0');
                            if(solve(grid)) return true;
                            grid[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canPlaceAt(int num, int row, int col, char[][] grid) {
        for(int i = 0; i < grid.length;i++) {
            if (grid[row][i] == (char) (num + '0')) {
                return false;
            }
            if (grid[i][col] == (char) (num + '0')) {
                return false;
            }
            if(grid[3 * (row/3) + i/3][3 * (col/3) + i % 3] == (char)(num + '0')) return false;
        }

        return true;
    }
}