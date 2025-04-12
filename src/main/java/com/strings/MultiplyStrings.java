package com.strings;

//43. Multiply Strings
//https://leetcode.com/problems/multiply-strings/description/
public class MultiplyStrings {
    // Using elementary maths multiplication and taking placeholder Array to store digits
    // Most Optimal sol with TC = O(l1 * l2) and SC = O(l1 + l2)
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] arr = new int[l1+l2];

        for(int i=l1-1;i>=0;i--){
            for(int j=l2-1;j>=0;j--){
                int digit = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int index1 = (l1-1) - i;
                int index2 = (l2-1) - j;
                arr[index1 + index2] += digit;
                arr[index1 + index2 + 1] += arr[index1 + index2] / 10;
                arr[index1 + index2] = arr[index1 + index2]%10;
            }
        }
        // System.out.println("Arr : " + Arrays.toString(arr));
        // System.out.println("6 : " + ('6' - '0'));
        String ans = "";
        for(int i : arr) ans = i + ans;
        int start = 0;
        while(true){
            if(ans.charAt(start) != '0') break;
            start++;
        }
        return ans.substring(start, ans.length());
    }
}
