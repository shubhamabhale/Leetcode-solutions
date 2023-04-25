class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mapper= new HashMap<>();
        for(String str  : strs)
        {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sorted = new String(chArr);
            if(!mapper.containsKey(sorted))
            {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                mapper.put(sorted, temp);
            }
            else
            {
                List<String> temp = mapper.get(sorted);
                temp.add(str);
                mapper.put(sorted, temp);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> e : mapper.entrySet())
        {
            ans.add(e.getValue());
        }
        return ans;
    }
}