package arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while(i<s.length()){
            for(int j=0; j<numRows && i < s.length(); j++){
                sb[j].append(s.charAt(i));
                i++;
            }
            for(int j=numRows-2; j>0 && i < s.length(); j--){
                sb[j].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(i=0; i<sb.length; i++){
            for(int j=0; j<sb[i].length(); j++){
                result.append(sb[i].charAt(j));
            }
        }

        return result.toString();
    }
}
