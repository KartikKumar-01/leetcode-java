class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack= new Stack<>();
        int insertions = 0;
        for(int i=0; i< s.length(); i++){
            char ch= s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if (i+1<s.length() &&  s.charAt(i+1) == ')'){
                    i++;    
                }
                else{
                    insertions++;
                }

                if(stack.isEmpty()){
                    insertions++;
                }
                else{
                    stack.pop();
                }
            }
        }
        insertions += stack.size() * 2;
        return insertions;
    }
}