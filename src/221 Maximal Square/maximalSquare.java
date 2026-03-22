class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] mat=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=matrix[i][j]-'0';
            }
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) continue;
                if(i>0 && j>0){
                    int val=Math.min(mat[i-1][j-1], Math.min(mat[i-1][j],mat[i][j-1]));
                    mat[i][j]=val+1;
                }
                maxArea=Math.max(maxArea,mat[i][j]);
            }
        }
        return maxArea*maxArea;
    }
}