class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //table of dependencies
        int[][] mark = new int[numCourses][numCourses];
        for(int [] tab : prerequisites){
            mark[tab[0]][tab[1]] = 1;
        }
        
        int [] visited = new int[numCourses];
        
        for(int i=0;i<visited.length;i++){
            if(cycle(mark,visited,i))//check if it exists a cycle
                return false;
        }
        return true;
    }
    public boolean cycle(int [][] mark, int [] visited, int index){
        visited[index]=1;
        for(int i=0;i<mark.length;i++){
            if(mark[index][i]==1){
                if(visited[i]==1)   return true;
                if(visited[i]==0 && cycle(mark,visited,i))   return true;
            }
        }
        visited[index]=2;
        return false;
    }
}
