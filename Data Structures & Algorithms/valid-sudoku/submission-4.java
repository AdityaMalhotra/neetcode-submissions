class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hashSet = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.' && hashSet.contains(board[i][j])){
                    return false;
                }
                hashSet.add(board[i][j]);
            }
            hashSet.clear();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]!='.' && hashSet.contains(board[j][i])){
                    return false;
                }
                hashSet.add(board[j][i]);
            }
            hashSet.clear();
        }
        for(int imax = 3;imax<board.length;imax+=3){
            for(int jmax = 3;jmax<board[imax].length;jmax+=3){
                for(int i = imax-3;i<imax;i++){
                    for(int j = jmax-3;j<jmax;j++){
                        if(board[i][j]!='.' && hashSet.contains(board[i][j])){
                            return false;
                        }
                        hashSet.add(board[i][j]);
                    }
                }
                hashSet.clear();
            }
        }
        return true;
    }
}
