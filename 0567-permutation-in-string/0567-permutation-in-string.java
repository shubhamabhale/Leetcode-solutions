class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
        {
            return false;
        }

        HashMap<Character, Integer> keyMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(int i=0;i<s1.length();i++)
        {
            keyMap.put(s1.charAt(i), keyMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int i=0,j=s1.length()-1;
        for(int k=i;k<=j;k++)
        {
            windowMap.put(s2.charAt(k), windowMap.getOrDefault(s2.charAt(k), 0) + 1);
        }
        while(j<s2.length())
        {
            if(windowMap.equals(keyMap))
            {
                return true;
            }
            if(windowMap.containsKey(s2.charAt(i)) && (windowMap.get(s2.charAt(i)) != 1))
            {
                windowMap.put(s2.charAt(i), windowMap.get(s2.charAt(i))-1);
            }
            else
            {
                windowMap.remove(s2.charAt(i));
            }
            j++;
            if(j==s2.length())
                break;
            windowMap.put(s2.charAt(j), windowMap.getOrDefault(s2.charAt(j),0)+1);
            i++;
            
        }
        return false;
    }
}