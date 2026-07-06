class Solution {
    public int trap(int[] height) {
        int[] presum = new int[height.length];
        int[] sufsum = new int[height.length];
        int[] ans = new int[height.length];
        
        presum[0] = height[0];
        for(int i = 1;i<height.length;i++){
            if(height[i]>presum[i-1]){
                presum[i] = height[i];
            }
            else{
                presum[i] = presum[i-1];
            }
        }

        sufsum[height.length-1] = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            if(height[i]>sufsum[i+1]){
                sufsum[i] = height[i];
            }else{
                sufsum[i] = sufsum[i+1];
            }
        }

        for(int i = 0; i<height.length;i++){
            ans[i] = Math.min(presum[i],sufsum[i])-height[i];
        }

        int result = 0;
        for(int i = 0;i<height.length;i++){
            result += ans[i];
        }
        return result;

    }
}