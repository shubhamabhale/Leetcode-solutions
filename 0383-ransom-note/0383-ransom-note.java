class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        
        for(int i=0;i<magazine.length();i++)
        {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        
        for(int i=0;i<ransomNote.length();i++)
        {
            if(magazineMap.containsKey(ransomNote.charAt(i)))
            {
                if(magazineMap.get(ransomNote.charAt(i))<=0)
                {
                    return false;
                }
                else
                {
                    magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i))-1);
                }
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
}