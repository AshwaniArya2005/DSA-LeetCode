class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
        List<String> l1 = new ArrayList<>();
            String temp = strs[i];
            char[] a = temp.toCharArray();
            Arrays.sort(a);
            String key = new String(a);

            if(hm.containsKey(key)){
                hm.get(key).add(strs[i]);
            }else{
                l1.add(strs[i]);
                hm.put(key,l1);
            }
            
        }
        List<List<String>> ans = new ArrayList<>(hm.values());
        // ans = hm.values();
        return ans;
    }
}