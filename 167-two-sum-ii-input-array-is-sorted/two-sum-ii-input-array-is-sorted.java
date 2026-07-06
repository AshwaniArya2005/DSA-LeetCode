class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        int sum = 0;
        int[] index = new int[2];
        while(i<j){
            sum = numbers[i]+numbers[j];
            if(sum>target){
                j--;
            }
            else if(sum<target){
                i++;
            }
            else{
                index[0] = i+1;
                index[1] = j+1;
                break;
            }
        }
        return index;
    }
}