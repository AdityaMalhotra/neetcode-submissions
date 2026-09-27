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

        for(int rowBox = 0;rowBox<3;rowBox++){
            for(int colBox = 0;colBox<3;colBox++){
                for(int i=rowBox*3;i<(rowBox*3)+3;i++){
                    for(int j=colBox*3;j<(colBox*3)+3;j++){
                        if(board[i][j]!='.'){
                            if(rowSet.contains(board[i][j])) return false;
                            rowSet.add(board[i][j]);
                        }
                    }
                }
                rowSet.clear();
            }
        }
        return true;

    }
// [
// [".",".",".",".","5",".",".","1","."],
// [".","4",".","3",".",".",".",".","."],
// [".",".",".",".",".","3",".",".","1"],
// ["8",".",".",".",".",".",".","2","."],
// [".",".","2",".","7",".",".",".","."],
// [".","1","5",".",".",".",".",".","."],
// [".",".",".",".",".","2",".",".","."],
// [".","2",".","9",".",".",".",".","."],
// [".",".","4",".",".",".",".",".","."]
// ]
}
