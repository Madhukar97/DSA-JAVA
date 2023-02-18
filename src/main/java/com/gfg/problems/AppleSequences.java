package com.gfg.problems;


//https://practice.geeksforgeeks.org/problems/38f100615d0b2efa755e7b07f905e0f8cd2fe5df/1
public class AppleSequences {

    public static void main(String[] args) {
        String str = "asd awdwsqafd";
        System.out.println(appleSequence2(5,1, "AAOAO"));
//        System.out.println(appleSequence2(7,1, "AAAOAAA "));
    }

    public static int appleSequence2(int n, int m, String arr){  //AAOAO
        int max = 0;
        int start = 0;
        int end = 0;
        int len = 0;
        int spells = m;
        int previousO = start;

        while(start < n){
            while(end < n && spells > 0){
                if(arr.charAt(end) == 'O'){
                    spells--;
                }
                end++;
            }
            while(end < n){
                if(arr.charAt(end) == 'A'){
                    end++;
                }else break;
            }
            max = Math.max(max, end-start);
            System.out.println("s = " + start + ", e ="  +end + " length = " + max);
            spells++;
            while(true){
                if(arr.charAt(start) == 'O') {
                    start++;
                    break;
                }
                start++;
            }
        }
        return max;
    }




    public static int appleSequence(int n, int m, String arr){  //AAOAO
        int longestApple = 0;
        int ans = 0;
        int pointer = 1;

        while(pointer < n) {
            System.out.println("outer while entered with pointer :: " + pointer);
            int spells = m;
            int curr = pointer;

            if(arr.charAt(curr) == 'O' && arr.charAt(curr-1) == 'A') {
                longestApple = 0;
                int sIndex = curr-1;
                while(sIndex >= 0) {
                    if (arr.charAt(sIndex) == 'A') {
                        longestApple++;
                        sIndex--;
                    } else break;
                }
                System.out.println("left part length :: " + longestApple);
                int eIndex = pointer;
                while(spells > 0 && eIndex < n) {
                    System.out.println("eIndex entered with val :: "+eIndex);
                    if(arr.charAt(eIndex) == 'O'){
                        spells--;
                        longestApple++;
                        eIndex++;
                    }else {
                        longestApple++;
                        eIndex++;
                    }
                }
                while(eIndex < n){
                    if(arr.charAt(eIndex) == 'A'){
                        eIndex++;
                        longestApple++;
                    }else break;
                }
                System.out.println("sIndex = " + sIndex + ", eIndex= " + eIndex + ", length ="+longestApple);
            }
            pointer++;
            while(pointer < n-1){
                System.out.println("current pointer = " + pointer);
                if(arr.charAt(pointer) == 'O' && arr.charAt(pointer-1) == 'A') {
                    break;
                }
                else pointer++;
            }
            if(longestApple > ans) ans = longestApple;
        }
        return ans;
    }
}
