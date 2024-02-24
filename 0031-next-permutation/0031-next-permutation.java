class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;        
    }
    
    public void reverseArr(int[] nums, int start){
        int i = start, j= nums.length-1;
        while(i<j){
            swap(nums, i , j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        if(nums.length == 0)
            return;
        
        int i = nums.length - 1;
        while(i > 0){
            if(nums[i - 1] < nums[i]){
                for(int j = nums.length - 1; j >= i; j--){
                    if(nums[i - 1] < nums[j]){
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                reverseArr(nums, i); // Reverse the array from position i
                return;
            }
            i--;
        }
        // If the loop completes without finding the next permutation, reverse the entire array
        reverseArr(nums, 0);
    }
}
