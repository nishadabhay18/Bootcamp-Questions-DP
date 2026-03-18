class minimumPathSum {
    // RECURSION+MEMOIZATION
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        return pathSum(grid,m,n,0,0);
    }
    public int pathSum(int[][] grid, int m, int n, int i,int j){
        if(i==m-1 && j==n-1) return grid[i][j];
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        int down=pathSum(grid,m,n,i+1,j);
        int right=pathSum(grid,m,n,i,j+1);
        return grid[i][j]+Math.min(down,right);
    }
}