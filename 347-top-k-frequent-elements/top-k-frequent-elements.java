class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int i = 0;
        while(k>0){
        int maxfreq = 0;
        int maxelem = 0;
            for(Map.Entry<Integer, Integer> e: hm.entrySet()){
                if (e.getValue() > maxfreq) {
                    maxfreq = e.getValue();
                    maxelem= e.getKey();
                }

            
            }
            result[i++] = maxelem;
            // i++;
            k--;
            hm.remove(maxelem);
        }
        return result;

    }
}