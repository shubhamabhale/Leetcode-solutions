class Solution {
    public boolean compareStrings(String str1, String str2)
    {
        if(str1.equals(str2))
            return true;
        return false;
    }
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle))
            return 0;
        int window = needle.length();
        int start =0;
        int end = window-1;
        char f = needle.charAt(0);
        char l = needle.charAt(window-1);
        System.out.println(f + " " + l);
        while(end<haystack.length())
        {
            char chStart = haystack.charAt(start);
            char chEnd = haystack.charAt(end);
            System.out.println(chStart + " " + chEnd);
            if(chStart == f)
            {
                if(chEnd == l)
                {
                    if(compareStrings(needle, haystack.substring(start,end+1)))
                    {
                        return start;
                    }
                }
            }
            start++;
            end++;
        }
        return -1;
        
        
    }
}