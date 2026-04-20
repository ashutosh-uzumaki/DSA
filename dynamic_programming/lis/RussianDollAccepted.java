package dynamic_programming.lis;

import java.util.*;

public class RussianDollAccepted {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int n = envelopes.length;
        List<Integer> heights = new ArrayList<>();
        for(int i=0; i<n; i++){
            heights.add(envelopes[i][1]);
        }
        List<Integer> tails = new ArrayList<>();
        for(int i=0; i<n; i++){
            int idx = Collections.binarySearch(tails, heights.get(i));

            if(idx < 0){
                idx = -(idx + 1);
            }

            if(idx == tails.size()){
                tails.add(heights.get(i));
            }else{
                tails.set(idx, heights.get(i));
            }
        }
        return tails.size();
    }
}
