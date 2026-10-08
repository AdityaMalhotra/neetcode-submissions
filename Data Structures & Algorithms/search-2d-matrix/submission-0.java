class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int left = 0; right = rows*cols = matrix.length*matrix[0].length. 
        // mid = left + (right-left)/2; 
        // if we have mid, we get rowno = mid/matrix[0].length;. colno = mid%matrix[0].length;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows*cols-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int rowNum = mid/cols;
            int colNum = mid%cols;
            if(matrix[rowNum][colNum] == target){
                return true;
            }else if (matrix[rowNum][colNum] < target) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
