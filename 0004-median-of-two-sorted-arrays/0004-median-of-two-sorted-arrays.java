class Solution {
    public int[] mergeArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[n1+n2];
        
        int i1=0,i2=0, k=0;
        while(i1<n1 && i2<n2){
            if(nums1[i1]<nums2[i2]){
                ans[k] = nums1[i1];
                i1++;
                k++;
            } else if(nums2[i2]<nums1[i1]){
                ans[k]=nums2[i2];
                i2++;
                k++;
            } else {
                ans[k]=nums1[i1];
                k++;
                ans[k]=nums2[i2];
                k++;
                i1++;
                i2++;
            }
        }
        
        while(i1<n1)
        {
            ans[k]=nums1[i1];k++;
            i1++;
        }
        
        while(i2<n2)
        {
            ans[k]=nums2[i2];k++;
            i2++;
        }
        
        return ans;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] answer = mergeArrays(nums1, nums2);
        System.out.println(Arrays.toString(answer));
        if(answer.length%2!=0)
            return (double)Math.ceil(answer[answer.length/2]);
        else{
            int temp = (answer.length)/2 -1;
            
            double ans = answer[temp]+answer[temp+1];
            System.out.println(temp + " " + ans);
            return (double)ans/2;
        }
    }
}