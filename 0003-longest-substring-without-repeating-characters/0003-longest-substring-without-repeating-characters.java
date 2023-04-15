class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        TreeSet<Character> set = new TreeSet<>();
        int max_len=-1;
        int len=0;
        for(int i=0;i<s.length();i++)
        {

            if(!set.contains(s.charAt(i)))
            {
                set.add(s.charAt(i));
                len++;
                if(max_len<len)
                {
                    max_len = len;
                }
            }
            else
            {
                set.clear();
                i = i-len;
                len=0;
                
            }
        }
        return max_len;
    }
}