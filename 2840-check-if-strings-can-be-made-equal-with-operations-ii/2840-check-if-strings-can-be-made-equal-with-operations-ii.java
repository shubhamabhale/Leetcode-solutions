class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];
        Arrays.fill(even,0);
        Arrays.fill(odd,0);
        
        for(int i=0;i<s1.length();i++)
        {
            if(i%2==0)
            {
                even[s1.charAt(i)-'a']++;
            }
            else {
                odd[s1.charAt(i)-'a']++;
            }
        }
        
        for(int i=0;i<s2.length();i++)
        {
            if(i%2==0)
            {
                even[s2.charAt(i)-'a']--;
            }
            else {
                odd[s2.charAt(i)-'a']--;
            }
        }  
        
        for(int i=0;i<26;i++)
        {
            System.out.println(even[i] + " " + odd[i]);
            if(even[i]!=0)
            {
                return false;
            }
            if(odd[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}