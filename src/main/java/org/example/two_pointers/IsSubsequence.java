package org.example.two_pointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(i >= 0 && j >= 0){
            if(s.charAt(i) == t.charAt(j)){
                i--;
                j--;
            }else{
                j--;
            }
        }

        if(i < 0){
            return true;
        }

        return false;
    }
}
