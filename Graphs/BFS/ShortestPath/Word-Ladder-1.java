import java.util.*;

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (char i = 0; i < pair.word.length(); i++) {
                char[] arr = pair.word.toCharArray();
                for (int j = 0; j < 26; j++) {
                    arr[i] = (char) (j + 'a');
                    String newWord = new String(arr);
                    if(!set.contains(newWord)) continue;
                    if (newWord.equals(endWord))
                        return pair.steps + 1;
                    else {
                        q.add(new Pair(newWord, pair.steps + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        String[] arr2 = {"hot","dot","dog","lot","log"};
        System.out.println(sol.ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList(arr2))));
    }
}