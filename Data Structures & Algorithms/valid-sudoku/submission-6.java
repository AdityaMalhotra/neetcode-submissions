class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hashSet = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    if(hashSet.contains(board[i][j])){
                        return false;
                    }
                    hashSet.add(board[i][j]);
                }
            }
            hashSet.clear();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]!='.'){
                    if(hashSet.contains(board[j][i])){
                        return false;
                    }
                    hashSet.add(board[j][i]);
                }
            }
            hashSet.clear();
        }
        for(int iBoundary = 0;iBoundary<3;iBoundary++){
            for(int jBoundary = 0;jBoundary<3;jBoundary++){
                for(int i=iBoundary*3;i<(iBoundary*3)+3;i++){
                    for(int j=jBoundary*3;j<(jBoundary*3)+3;j++){
                        if(board[i][j]!='.'){
                            if(hashSet.contains(board[i][j])){
                                return false;
                            }
                            hashSet.add(board[i][j]);
                        }
                    }
                }
                hashSet.clear();
            }
        }
        return true;
    }
}
