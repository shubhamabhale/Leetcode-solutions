class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public void recurse(int numRows, int level) {
        if(numRows==level)
            return;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        List<Integer> temp = answer.get(level-1);
        for(int i=1;i<=level-1;i++)
        {
            res.add(temp.get(i) + temp.get(i-1));
        }
        res.add(1);
        answer.add(res);
        recurse(numRows, level+1);
    }
    public List<List<Integer>> generate(int numRows) {
        
       List<Integer> temp = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp.add(1);
        answer.add(temp);
        if(numRows==1)
            return answer;
        temp1.add(1);
        temp1.add(1);
        answer.add(temp1);
        if(numRows==2)
            return answer;
        //System.out.println(answer);
        recurse(numRows,2);
        return answer;
    }
}