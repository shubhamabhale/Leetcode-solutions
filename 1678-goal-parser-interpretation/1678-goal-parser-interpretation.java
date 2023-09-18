class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<command.length();i++)
        {
            Character ch = command.charAt(i);
            switch (ch) {
                case 'G' : 
                    sb.append("G");
                    break;
                case '(' :
                    if(command.charAt(i+1)=='a'){
                        sb.append("al");
                        i=i+3;
                    }
                    else{
                        sb.append("o");
                        i=i+1;
                    }
                    break;    
                }
        }
        return sb.toString();
    }
        
}