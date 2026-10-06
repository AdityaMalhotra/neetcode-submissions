class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0;i<tokens.length;i++){
            int toBeInserted;
            if(tokens[i].equals("+")){
                int first = stack.pop();
                int second = stack.pop();
                toBeInserted = second+first;
            }else if(tokens[i].equals("-")){
                int first = stack.pop();
                int second = stack.pop();
                toBeInserted = second-first;
            }else if(tokens[i].equals("*")){
                int first = stack.pop();
                int second = stack.pop();
                toBeInserted = second*first;
            }else if(tokens[i].equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                toBeInserted = second/first;
            }else{
                toBeInserted = Integer.parseInt(tokens[i]);
            }
            stack.push(toBeInserted);
        }
        return stack.pop();
    }
}
