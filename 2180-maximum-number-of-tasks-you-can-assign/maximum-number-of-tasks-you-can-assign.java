class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0;
        int h = Math.min(tasks.length,workers.length);
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(tasks,workers,m,pills,strength)){
                ans = m;
                l = m+1;
            }else{
                h = m-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int []tasks,int []workers,int m,int pills,int strength){
        int count = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=workers.length-m;i<workers.length;i++){
            map.put(workers[i],map.getOrDefault(workers[i],0)+1);
        }
        for(int i=m-1;i>=0;i--){
            int find = tasks[i];
            if(map.ceilingKey(find)!=null){
                int key = map.ceilingKey(find);
                map.put(key,map.get(key)-1);
                if(map.get(key)==0){
                    map.remove(key);
                }
            }else{
                if(pills==0){
                    return false;
                }
                pills--;
                find-=strength;
                if(map.ceilingKey(find)!=null){
                    int key = map.ceilingKey(find);
                    map.put(key,map.get(key)-1);
                    if(map.get(key)==0){
                        map.remove(key);
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}