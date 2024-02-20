package com.strings;

//415. Add Strings
//https://leetcode.com/problems/add-strings/description/
public class AddStrings {
    //Using elementary Maths addition
    //Most optimal sol with TC = O(max(l1,l2)) and SC = O(max(l1,l2)+1)
    public String addStrings(String num1, String num2) {
        if(num1.equals("0") && num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] arr = new int[l1+l2];
        int carry=0;
        int i=l1-1;
        int j=l2-1;

        while(i >=0 || j>=0){
            int digit = 0;
            if(i>=0) digit+= (num1.charAt(i)-'0');
            if(j >=0) digit += (num2.charAt(j)-'0');
            int index= Math.max(l1,l2) -1 - Math.max(i,j);
            arr[index] += digit;
            arr[index + 1] = arr[index] / 10;
            arr[index] = arr[index]%10;
            // System.out.println("Arr : " + Arrays.toString(arr));
            i--;
            j--;
        }
        // System.out.println("6 : " + ('6' - '0'));
        String ans = "";
        for(int k : arr) ans = k + ans;
        int start = 0;
        while(start < ans.length()){
            if(ans.charAt(start) != '0') break;
            start++;
        }
        return ans.substring(start, ans.length());
    }
}
