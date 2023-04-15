class Solution {
    public HashMap<Integer,List<Character>> mapper = new HashMap<>();
    StringBuilder temp = new StringBuilder();
    public void recurse(String digits, int ptr, ArrayList<String> ans)
    {
        if(ptr>=digits.length())
        {
            ans.add(temp.toString());
            return ;
        }
        //StringBuilder temp ="";
        int digit = digits.charAt(ptr) - 48;
        //System.out.println(digit);
        int cnt = mapper.get(digit).size();
        
        for(int i=0;i<cnt;i++)
        {
            
            temp.append(mapper.get(digit).get(i));
            recurse(digits, ptr+1, ans);
            temp.setLength(temp.length()-1);
        }
        
        
        
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
        {
            return new ArrayList<>();
        }
        mapper.put(2,new ArrayList<>(Arrays.asList('a','b','c')));
        mapper.put(3,new ArrayList<>(Arrays.asList('d','e','f')));
        mapper.put(4,new ArrayList<>(Arrays.asList('g','h','i')));
        mapper.put(5,new ArrayList<>(Arrays.asList('j','k','l')));
        mapper.put(6,new ArrayList<>(Arrays.asList('m','n','o')));
        mapper.put(7,new ArrayList<>(Arrays.asList('p','q','r','s')));
        mapper.put(8,new ArrayList<>(Arrays.asList('t','u','v')));
        mapper.put(9,new ArrayList<>(Arrays.asList('w','x','y','z')));

        ArrayList<String> ans = new ArrayList<>();
        recurse(digits,0,ans);
        //System.out.println(recurse(digits,0));
        return ans;
        
    }
}