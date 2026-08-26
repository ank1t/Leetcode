import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = buildAdjacencyList(numCourses, prerequisites, indegree);

        return bfsToFindOrder(numCourses, adjList, indegree);
    }

    int[] bfsToFindOrder(int N, ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }

        while(!q.isEmpty()) {
            int indegree0 = q.poll();

            for(int vertex: adj.get(indegree0)) {
                indegree[vertex]--;
                if(indegree[vertex] == 0) {
                    q.add(vertex);
                    ans.add(vertex);
                }
            }
        }
        if(ans.size() != indegree.length) return new int[0];

        int[] ansList = new int[N];
        int index = 0;
        for(int num : ans) {
            ansList[index++] = num;
        }
        return ansList;
    }

    ArrayList<ArrayList<Integer>> buildAdjacencyList(int N, int[][] prereqs, int[] indegree) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i < N;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] prereq: prereqs) {
            adjList.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
        return adjList;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] prereq = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(sol.findOrder(4, prereq)));
    }
}