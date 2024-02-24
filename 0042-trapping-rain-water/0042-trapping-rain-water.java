class Solution {
    public int trap(int[] height) {
        if(height.length==0 ){
            return -1;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, Integer.MIN_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        left[0] = height[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[n-1] = height[n-1];
        for(int j= n-2;j>=0;j--){
            right[j] = Math.max(right[j+1], height[j]);
        }
        
        int ans  =0;
        for(int i=0;i<n;i++){
            ans += Math.min(left[i],right[i]) - height[i];
        }
        
        return ans;
    }
}