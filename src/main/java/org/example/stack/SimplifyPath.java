package org.example.stack;

public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            Stack<String>st = new Stack<>();
            String[] p = path.split("/");

            for(int i=0; i<p.length; i++){
                if(st.size() > 0 && p[i].equals("..")){
                    st.pop();
                }

                else if(!p[i].equals(".") && !p[i].equals("") && !p[i].equals("..")){
                    st.push(p[i]);
                }
            }

            return "/"+String.join("/", st);
        }
    }
}
