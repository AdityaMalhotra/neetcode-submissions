class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    if(rowSet.contains(board[i][j])) return false;
                    rowSet.add(board[i][j]);
                }
            }
            rowSet.clear();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]!='.'){
                    if(rowSet.contains(board[j][i])) return false;
                    rowSet.add(board[j][i]);
                }
            }
            rowSet.clear();
        }

        int iBoundary = 0;
        int jBoundary = 0;
        while(iBoundary < 9 && jBoundary<9){
            for(int i=iBoundary;i<iBoundary+3;i++){
                for(int j=jBoundary;j<jBoundary+3;j++){
                    if(board[j][i]!='.'){
                        if(rowSet.contains(board[j][i])) return false;
                        rowSet.add(board[j][i]);
                    }
                }
            }
            iBoundary+=3;
            jBoundary+=3;
            rowSet.clear();
        }
        return true;

    }
}
