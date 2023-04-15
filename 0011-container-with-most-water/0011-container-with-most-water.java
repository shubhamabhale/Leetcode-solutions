class Solution {
    
    public int getArea(int x1, int x2, int ht)
    {
        return Math.abs(x1-x2)*ht;
    }
    public int maxArea(int[] height) {
        int maxA = -1;
        int i=0;
        int j= height.length-1;

        while(j>=0 && i<height.length)
        {
            int temp = getArea(i,j,Math.min(height[i],height[j]));
            System.out.println(temp);
            if(maxA<temp)
            {
                maxA = temp;
            }
            if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return maxA;
        
    }
}