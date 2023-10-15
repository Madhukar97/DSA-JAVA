package com.strings;

//12. Integer to Roman
//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {
    //Sol with time O(1) and space O(1)
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
    //Sol with time O(1) and space O(1)
    //use StringBuilder for x3 fast execution
    public String intToRomanSol2(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};

        StringBuilder ans = new StringBuilder();

        ans.append(ths[num / 1000]);
        ans.append(hrns[(num % 1000) / 100]);
        ans.append(tens[(num % 100) / 10]);
        ans.append(ones[num % 10]);

        return ans.toString();
    }
}
