class Solution {
    
    public boolean isValidSerialization(String preorder) {
        if(preorder.length()==0){
            return false;
        }    
        if(preorder.equals("#"))
            return true;
        
        String[] str = preorder.split(",");
        //System.out.println(Arrays.toString(str));
        int cnt = 1;
        int index = 0;
        while(index<str.length){
            String ch = str[index];
            cnt--;
            if(cnt<0)
                return false;
            try{
                if(Integer.parseInt(ch)!=-1){
                    cnt += 2;
                }
            } catch(Exception e){
                
            }
            
            index++;
        }
        return cnt==0;
        
    }
}