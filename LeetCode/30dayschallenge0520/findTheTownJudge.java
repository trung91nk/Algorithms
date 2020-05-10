//Directed Graph
class Solution{
      public int findJudge(int N, int[][] trust) {
          int[] count = new int[N+1];
          for (int[] t: trust) {
              count[t[0]]--;
              count[t[1]]++;
          }
          for (int i = 1; i <= N; ++i) {
              if (count[i] == N - 1) return i;
          }
          return -1;
      }
}
//HashMap
class Solution {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i=0;i<trust.length;i++){
            if(!map.containsKey(trust[i][0])){
                map.put(trust[i][0], new ArrayList());
            }
            map.get(trust[i][0]).add(trust[i][1]);
        }
        List<Integer> judges = new ArrayList();
        for(int i=1;i<=N;i++){
            if(!map.containsKey(i)){
                judges.add(i);
            }
        }
        if(judges.size()!=1){
            return -1;
        }else{
            boolean realJudge = true;
            for(int i=1;i<=N;i++){
                if(i!=judges.get(0)){
                    if(!map.get(i).contains(judges.get(0))){
                        realJudge = false;
                        break;
                    }
                }
            }
            return realJudge? judges.get(0):-1;
        }
    }
}
