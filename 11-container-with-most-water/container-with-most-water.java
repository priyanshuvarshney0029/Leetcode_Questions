class Solution {
    public int maxArea(int[] height) {
      int mosw=0;
      int i=0;
      int j=height.length-1;
      
      while(i<j){
          int width=j-i;
          int h=Math.min(height[i],height[j]);
          int area=h*width;
          mosw=Math.max(mosw,area);

          if(height[i]>height[j]){
              j--;
          }
          else{
              i++;
          }
      }
      return mosw;
    }
}