class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]>candies[max])
            {
                max = i;
            }
        }
        ArrayList<Boolean> ans = new ArrayList<>();
        for(int i=0;i<candies.length;i++)
        {
            if(extraCandies + candies[i]>=candies[max])
            {
                ans.add(true);
            }
            else
            {
                ans.add(false);
            }
        }
        return ans;
    }
}