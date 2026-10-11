class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows*cols;
        int right = size-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int rowIndex = mid/cols;
            int colIndex = mid%cols;
            if(matrix[rowIndex][colIndex] == target){
                return true;
            }else if(matrix[rowIndex][colIndex]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
