package arrays;

import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();

            curr.add(1);

            // Only access previous row if it exists
            if(i > 0){
                List<Integer> prevRow = result.get(i - 1);

                for(int j = 1; j < prevRow.size(); j++){
                    curr.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                curr.add(1); // last element
            }

            result.add(curr);
        }

        return result;
    }
}
