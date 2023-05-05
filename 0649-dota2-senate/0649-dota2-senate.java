class Solution {
    
    public boolean ban(StringBuilder str, int startAt, char toBan)
    {
        int pointer = startAt;
        boolean loopbefore = false;
        
        while(true)
        {
            if(pointer==0)
                loopbefore= true;
            if(str.charAt(pointer)==toBan)
            {
                str.deleteCharAt(pointer);
               break;
            }
            pointer = (pointer +1)%str.length();
        }
        return loopbefore;
    }
    public String predictPartyVictory(String senate) {
        
        StringBuilder sb = new StringBuilder(senate);
        int dCount=0,rCount=0;
        for(int i=0;i<senate.length();i++)
        {
            if(senate.charAt(i)=='D')
            {
                dCount++;
            }
            else
            {
                rCount++;
            }
        }
        int turn=0;
        while(dCount>0 && rCount>0)
        {
            if(sb.charAt(turn)=='D')
            {
             
                boolean loopbefore = ban(sb,(turn+1)%sb.length(),'R');
               
                if(loopbefore)
                {
                    turn--;
                }
                 rCount--;
            }
            else
            {
                boolean loopbefore = ban(sb,(turn+1)%sb.length(),'D');
                
                if(loopbefore)
                {
                    turn--;
                }
                dCount--;
            }
            turn=(turn+1)%sb.length();
        }
        
        if(rCount>0)
            return "Radiant";
        return "Dire";
    }
    
}