class Solution {
    int maxcount = Integer.MAX_VALUE;
    
    public void recurse(String str, int start, int end, int k, int count) {
        if(end>= str.length())
        {
            maxcount = Math.min(maxcount, count);
            return;
        }
        String subst = str.substring(start, end+1);
        String digits=Integer.toString(k);
        if(subst.length() <= digits.length() && Integer.parseInt(subst) <= k) {
            recurse(str, start, end + 1, k, count);
        }
        else 
        {
            subst = str.substring(end, end+1);
            if(Integer.parseInt(subst) > k)
                return;
            recurse(str, end, end + 1, k, count + 1);            
        }        
    }
    
    public int minimumPartition(String s, int k) {
        
        recurse(s, 0, 0, k, 1);
        return maxcount == Integer.MAX_VALUE ? -1 : maxcount;
    }
}