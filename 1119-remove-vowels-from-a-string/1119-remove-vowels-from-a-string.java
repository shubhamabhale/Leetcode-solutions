class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'u' || ch == 'o' || ch == 'i' || ch == 'e')
            return true;
        return false;
    }
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            if(!isVowel(ch))
                sb.append(ch);
        }
        return sb.toString();
    }
}