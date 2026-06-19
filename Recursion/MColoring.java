class Scratch {
    public static void main(String[] args) {
        var solution = new Solution();
        int[][] edges = {{0, 1}, {1, 3},{2, 3}, {3, 0},{0, 2}};
        System.out.println(solution.graphColoring(4, edges, 4));
    }
}

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        int[] color = new int[v];
        return solve(v, edges, m, 0, color);
    }

    boolean solve(int numOfNodes, int[][] edges, int numOfColors, int currentNode, int [] color) {
        if(currentNode == numOfNodes) { return true; }

        for(int i = 1;i <= numOfColors;i++) {
            if(canColor(edges, color, i, currentNode)) {
                color[currentNode] = i;
                if(solve(numOfNodes, edges, numOfColors, currentNode + 1, color)) return true;
                color[currentNode] = 0;
            }
        }
        return false;
    }

    boolean canColor(int[][] edges, int [] color, int targetColor, int currentNode) {
        for(int[] edge: edges) {
            if((edge[0] == currentNode && color[edge[1]] == targetColor) ||
                    (edge[1] == currentNode && color[edge[0]] == targetColor)) return false;
        }
        return true;
    }
}