class Solution {
    private int index=0;
    public String decodeString(String s) {
        StringBuilder currentString= new StringBuilder();

        while(index<s.length() && s.charAt(index)!=']'){
            if(Character.isDigit(s.charAt(index))){
                int repeatCount=0;
                while(index<s.length() && s.charAt(index)!='['){
                    repeatCount= repeatCount*10 + (s.charAt(index)-'0');
                    index++;
                }

                index++;

                String inside= decodeString(s);

                index++;

                for(int i=0;i<repeatCount;i++){
                    currentString.append(inside);
                }
            }
            else{
                currentString.append(s.charAt(index));
                index++;
            }
        }
        return currentString.toString();
    }
}