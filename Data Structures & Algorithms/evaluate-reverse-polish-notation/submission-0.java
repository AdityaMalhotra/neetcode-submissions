class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(tokens[0]));
        int i =1;
        int result = Integer.parseInt(tokens[0]);
        while (!stack.isEmpty()){
            if(i>tokens.length-1){
                if(stack.size() == 1){
                    result = stack.pop();
                    return result;
                }
            }
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int op1 = stack.pop();
                int op2 = stack.pop();

                if(tokens[i].equals("+")){
                    stack.push(op2 + op1);
                } else if(tokens[i].equals("-")){
                    stack.push(op2 - op1);
                }else if(tokens[i].equals("*")){
                    stack.push(op2 * op1);
                }else {
                    stack.push(op2 / op1);
                }
            } else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return result;
    }
}
