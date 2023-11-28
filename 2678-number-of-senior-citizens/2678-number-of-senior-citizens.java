class Solution {
    public int countSeniors(String[] details) {
        if(details.length==0)
            return 0;
        int cnt =0;
        for(String detail: details){
            if(Integer.parseInt(detail.substring(11, 13))>60)
            {
                cnt++;
            }
        }
        return cnt;
    }
}