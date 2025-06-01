class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        Dsu obj=new Dsu(n);
        int count=0;
        for(int i=1;i<=n;i++){
           for(int j=0;j<n;j++){
              if(isConnected[i-1][j]==1){
                  obj.Union(i,j+1);
              }
           }
        }
         for(int i=1;i<=n;i++){
          
           if(obj.find(i)==i){
            count++;
           }
        }
        return count;
        
       
    }
    class Dsu{
        int rank[];
        int parent[];

        public Dsu(int n){
            rank=new int[n+1];
            parent=new int[n+1];

            for(int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
        public int find(int nn){
            if(nn==parent[nn]){
                return nn;
            }
            return parent[nn]=find(parent[nn]);
        }
        public void Union(int v1,int v2){
            int parent1=find(v1);
            int parent2=find(v2);

           if(parent1==parent2){
                return;
           }
           if(rank[parent1] < rank[parent2]){
               parent[parent1]=parent2;
           }
           else if(rank[parent1] > rank[parent2]){
               parent[parent2]=parent1;
           }
           else{
               parent[parent2]=parent1;
               rank[parent1]++;
           }
        }
    }
}