package com.strings;

//https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
public class CheckIfAParenthesesStringCanBeValid {
    public static void main(String[] args) {

    }

    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 != 0) return false;
        int oP = 0;
        int cP = 0;

        for(int i=0; i<s.length(); i++){
            if(locked.charAt(i) == '0'){
                oP++;
            }else{
                if(s.charAt(i) == '(') oP++;
                else cP++;
            }
            if(cP > oP) return false;
        }

        oP=0;cP=0;

        for(int i=s.length()-1; i>=0; i--){
            if(locked.charAt(i) == '0'){
                cP++;
            }else{
                if(s.charAt(i) == ')') cP++;
                else oP++;
            }
            if(oP > cP) return false;
        }
        return true;
    }
}
