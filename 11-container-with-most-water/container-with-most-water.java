class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxarea = Integer.MIN_VALUE;
        while(l<r){
            int area = Math.min(height[l],height[r])*(r-l);
            maxarea = Math.max(maxarea,area);

            if(height[l]<height[r]){
                l++;
            }else if(height[l]>height[r]){
                r--;
            }
            else{
                r--;
                l++;
            }
        }
        return maxarea;
    }
}