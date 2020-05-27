class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int [][] graph = new int[N][N];
        for(int [] arr : dislikes){
            graph[arr[0]-1][arr[1]-1]=1;
            graph[arr[1]-1][arr[0]-1]=1;
        }
        int [] node = new int[N];
        for(int i=0;i<N;i++){
            if(node[i]==0 && !dfs(graph,node,i,1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] node, int index ,int g){
        node[index]=g;
        for(int i=0;i<graph.length;i++){
            if(graph[index][i]==1){
                if(node[i]==g){
                    return false;
                }
                if(node[i]==0 && !dfs(graph,node,i,-g)){
                    return false;
                }
            }
        }
        return true;
    }
}
