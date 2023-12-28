package com.codestudio.stackandqueue;

//Stack Implementation Using Array
//https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class StackImplementationUsingArray {
    static class Stack {
        int[] arr;
        int top=-1;

        Stack(int capacity) {
            // Write your code here.
            arr=new int[capacity];
        }
        public void push(int num) {
            // Write your code here.
            if(top < arr.length-1)arr[++top]=num;
        }
        public int pop() {
            // Write your code here.
            if(top == -1) return -1;
            else{
                return arr[top--];
            }
        }
        public int top() {
            // Write your code here.
            if(top==-1) return -1;
            else return arr[top];
        }
        public int isEmpty() {
            // Write your code here.
            return top == -1 ? 1 : 0;
        }
        public int isFull() {
            // Write your code here.
            return top == arr.length-1 ? 1 : 0;
        }
    }

    //Revision 2
    public class Solution{
        static class Stack {
            int[] arr;
            int index=0;

            Stack(int capacity) {
                arr = new int[capacity];
            }
            public void push(int num) {
                if(index < arr.length){
                    arr[index++] = num;
                }
            }
            public int pop() {
                if(index > 0) return arr[index--];
                else return -1;
            }
            public int top() {
                if(index > 0) return arr[index];
                else return -1;
            }
            public int isEmpty() {
                return index==0 ? 1 : 0;
            }
            public int isFull() {
                return index == arr.length ? 1 : 0;
            }
        }
    }
}
