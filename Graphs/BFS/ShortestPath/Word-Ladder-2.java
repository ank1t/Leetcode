import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return new ArrayList<>();

        Queue<ArrayList<String>> q = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();

        int ansSeqCount = 0;
        int currSeqLen = 0;
        ArrayList<String> wordsToBeDeleted = new ArrayList<>();

        q.add(new ArrayList<>(List.of(beginWord)));

        while(!q.isEmpty()) {
            ArrayList<String> lastSeq = q.poll();
            String lastWordOfSeq = lastSeq.getLast();

            if(lastWordOfSeq.equals(endWord)) {
                if(lastSeq.size() > ansSeqCount) break;
                else if(lastSeq.size() == ansSeqCount) { ans.add(lastSeq); }
            }

            if(!wordsToBeDeleted.isEmpty() && lastSeq.size() > currSeqLen) {
                for(String word: wordsToBeDeleted) set.remove(word);
                wordsToBeDeleted.clear();
                if(set.isEmpty()) break;
            }

            for(int i = 0;i < lastWordOfSeq.length();i++) {
                char[] wordArr = lastWordOfSeq.toCharArray();

                for(int j = 0;j < 26;j++) {
                    wordArr[i] = (char)(j + 'a');
                    String newWord = new String(wordArr);
                    if(set.contains(newWord)) {
                        ArrayList<String> newList = new ArrayList<>(lastSeq);
                        newList.add(newWord);
                        q.add(newList);
                        wordsToBeDeleted.add(newWord);
                        currSeqLen = lastSeq.size();
                        if(endWord.equals(newWord)) { ansSeqCount = newList.size(); }
                    }
                }
            }
        }
        return ans;
    }
}

class Scratch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> wordList = new ArrayList<>();
        for(String word : words) {
            wordList.add(word);
        }
        System.out.println(sol.findLadders("hit", "cog", wordList));
    }
}