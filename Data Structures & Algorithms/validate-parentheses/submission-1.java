class Solution {//stack approach
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<>();
        Map<Character,Character> cl = new HashMap<>();
        cl.put(')','(');
        cl.put('}','{');
        cl.put(']','[');
        for(char c:s.toCharArray()){
            if(cl.containsKey(c)){
                if(!st.isEmpty() && st.peek()==cl.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
