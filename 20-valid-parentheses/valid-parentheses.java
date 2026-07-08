class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        // st.add(s.charAt(0));
        int i = 0;
        while(i<c.length){
            if(s.charAt(i)=='(' ||s.charAt(i)=='{'||s.charAt(i)=='[' ){
                st.push(s.charAt(i));
                i++;
            }else if(st.isEmpty() || c[i] == ')' && st.peek() != '(' || c[i] == '}' && st.peek() != '{'|| c[i] == ']' && st.peek() != '['){
                return false;
            }else{
                st.pop();
                i++;
            }
            
        }
        return(st.isEmpty());
    }
}