package graphs.bfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        dict.remove(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String currWord = queue.poll();
                if(currWord.equals(endWord)) return level;

                List<String> nbrs = getNeighboringWords(currWord, dict);
                for(String nbr: nbrs){
                    queue.offer(nbr);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> getNeighboringWords(String curr, Set<String> dict){
        char[] arr = curr.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            char original = arr[i];
            for(char c='a'; c<='z'; c++){
                arr[i] = c;
                String newStr = new String(arr);
                if(dict.contains(newStr)){
                    dict.remove(newStr);
                    res.add(newStr);
                }
            }
            arr[i] = original;
        }

        return res;
    }
}
