class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1=="")
            return word2;
        if(word2=="")
            return word1;
        
        int len1 = word1.length();
        int len2 = word2.length();
        int itr1 = 0;
        int itr2=0;
        StringBuilder sb= new StringBuilder();
        int t = 0;
        while(itr2<len2 && itr1<len1)
        {
            if(t==0)
            {    
                sb.append(word1.charAt(itr1));
                itr1++;
            }
            if(t==1)
            {
                sb.append(word2.charAt(itr2));
                itr2++;
            }
            t = 1-t;
        }
        while(itr1<len1)
        {
            sb.append(word1.charAt(itr1));
            itr1++;
        }
        while(itr2<len2)
        {
            sb.append(word2.charAt(itr2));
            itr2++;
        }
        return sb.toString();
    }
}