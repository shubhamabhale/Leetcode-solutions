class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapper = new HashMap<>();
        if(s.length()!=t.length() || s.length()==0 || t.length()==0)
            return false;
        
        for(int i=0;i<s.length();i++)
        {
            if(!mapper.containsKey(s.charAt(i)))
            {
                if(mapper.containsValue(t.charAt(i)))
                    return false;
                mapper.put(s.charAt(i),t.charAt(i));
            }
            else
            {
                if(mapper.get(s.charAt(i))!=t.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}