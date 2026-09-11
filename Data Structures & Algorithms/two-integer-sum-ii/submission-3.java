class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first=0,last =first+1;
        while(first<numbers.length){
            int sum= numbers[first]+numbers[last];
            if(sum ==target){
                return new int[] {first+1,last+1};
            }
            else if( last < numbers.length-1){
                last++;
            }
            else{
                first++;
                last=first+1;
            }
        }    
         return new int[0];

    }
}
