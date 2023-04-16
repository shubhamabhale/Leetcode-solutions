class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        	int sum=0,max = INT_MIN;
        int n = nums.size();
	for(int i=0;i<n;i++)
	{
		sum += nums[i];
		if(max<sum)
		{
			max=sum;
		}
		if(sum<0)
			sum=0;
	}
	return max;
        
    }
};