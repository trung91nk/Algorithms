public int minPathSum(int[][] grid) {
        /*if(grid==null || grid.length==0){
            return 0;
        }else if(grid.length == 1 && grid[0].length==1){
            return grid[0][0];
        }else{
            return sumMinAtCertainPoint(grid,grid.length-1,grid[0].length-1);
        }*/
        //DynamicProgramming
        for(int iRow=0;iRow<grid.length;iRow++){
            for(int iCol=0;iCol<grid[0].length;iCol++){
                if(iRow==0 && iCol==0){
                    grid[iRow][iCol] = grid[0][0];
                }else if(iRow==0 && iCol!=0){
                    grid[iRow][iCol]+=grid[iRow][iCol-1];
                }else if(iRow!=0 && iCol==0){
                    grid[iRow][iCol]+=grid[iRow-1][iCol];
                }else{
                    grid[iRow][iCol]+=Math.min(grid[iRow-1][iCol],grid[iRow][iCol-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    // Recursion
    public int sumMinAtCertainPoint(int[][] grid, int iRow,int iCol){
        int sum = grid[iRow][iCol];
        if(iRow==0 && iCol == 0){
            return grid[0][0];
        }else if(iRow ==0 && iCol>=1 && iCol<=grid[0].length-1){
            return sum+=sumMinAtCertainPoint(grid,iRow,iCol-1);
        }else if(iCol ==0 && iRow>=1 && iRow<=grid.length-1){
            return sum+=sumMinAtCertainPoint(grid,iRow-1,iCol);
        }else{
            return sum+= Math.min(sumMinAtCertainPoint(grid,iRow-1,iCol),sumMinAtCertainPoint(grid,iRow,iCol-1));
        }
    }
