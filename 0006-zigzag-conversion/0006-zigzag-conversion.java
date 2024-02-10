class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        
        int i=0;
        while(i<s.length()){
            for(int idx = 0;idx<numRows&&i<s.length();idx++, i++){
                sb[idx].append(c[i]);
            }
            for(int idx = numRows-2;idx>=1 && i<s.length();idx--,i++){
                sb[idx].append(c[i]);
            }
            
        }
        for(int itr=1;itr<sb.length;itr++){
            sb[0].append(sb[itr]);
        }
        
        return sb[0].toString();
    }
}