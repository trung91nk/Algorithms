class Solution {
    public int numIslands(char[][] grid) {
        try{
            int islands = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        islands++;
                        dfs(grid,i,j);
                    }
                }
            }
            return islands;
        }catch(Exception e){
            return 0;
        }
    }
    //DepthFirstSearch
    //after visisting a case denoted '1', transforme it to '0' like already visited and do recursion to 4 besides nodes -> define how many islands are isolated
    public void dfs(char[][] grid, int iRow, int iCol){
        int row = grid.length;
        int col = grid[0].length;
        if(iRow<0 || iRow>=row || iCol<0 || iCol>=col || grid[iRow][iCol]=='0'){
            return;
        }
        grid[iRow][iCol]='0';
        dfs(grid,iRow-1,iCol);
        dfs(grid,iRow+1,iCol);
        dfs(grid,iRow,iCol+1);
        dfs(grid,iRow,iCol-1);
    }
}
