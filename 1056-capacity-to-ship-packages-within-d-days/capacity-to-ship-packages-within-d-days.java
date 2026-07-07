class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int l = max;
        int r = sum;
        while (l < r) {
            int mid = (l + r) / 2;
            if (canShip(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean canShip(int[] weights, int mid, int days) {
        int sum = 0;
        int count = 1;
        for(int i = 0;i<weights.length;i++){
            if(weights[i]+sum <=mid){
                sum+= weights[i];
            }else{
                count++;
                sum = 0;
                sum+= weights[i];
            }
        }
        return count <= days;
        
    }
}