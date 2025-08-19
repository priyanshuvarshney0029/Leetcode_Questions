class Solution {
    public String frequencySort(String s) {
        int[][] arr=new int[256][2];
        for(int i=0;i<256;i++){
            arr[i][0]=i;
        }
        for(char c:s.toCharArray()){
            arr[c][1]++;
        }
        Arrays.sort(arr,(a,b)-> {
            if(a[1]==b[1])return a[0]-b[0];
           return b[1]-a[1];
    });
        StringBuilder str=new StringBuilder();
        for(int[] i:arr){
            char c=(char)(i[0]);
            int f=i[1];
            while(f-->0)str.append(c);
        }
        return str.toString();
    }
}