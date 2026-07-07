class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i =0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        int l = 1;
        int r = max;
        while(l<r){
            int mid = (l+r)/2;
            if(doesEat(piles, mid, h)){
                r = mid;   
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public boolean doesEat(int[] piles, int mid, int h){
        int count = 0;
        int[] temp = new int[piles.length];
        for(int i = 0; i<piles.length;i++){
            temp[i] = piles[i];
        }
        for(int i = 0; i<piles.length;i++){
            count += (piles[i]+mid-1)/mid;
        }

        if (count>h){
            return false;
        }
        return true;
    }
}