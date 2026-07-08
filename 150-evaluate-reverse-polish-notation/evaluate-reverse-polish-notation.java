class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int result = 0;
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                result = a+b;
                st.push(Integer.toString(result));
            }else if(tokens[i].equals("-")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                result = b-a;
                st.push(Integer.toString(result));
            }else if(tokens[i].equals("*")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                result = a*b;
                st.push(Integer.toString(result));
            }else if(tokens[i].equals("/")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                result = b/a;
                st.push(Integer.toString(result));
            }else{
                st.push(tokens[i]);
            }
        }
        
        return Integer.parseInt(st.pop());
    }
}