package arrays;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i += 1;
            j -= 1;
        }

        return true;
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}
