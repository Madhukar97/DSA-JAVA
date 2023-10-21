package com.trees.bst;

//Floor in BST
public class FloorInBST {
    class TreeNode<T>
    {
        public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    //do binary search using recursion : if(x < node.data) go left and node.data cannot be your ans,
    // if(x > node.data) node.data can be your potential ans so update ans[0]
    public static int floorInBST(TreeNode<Integer> root, int X) {
        int[] ans = new int[1];
        rec(root,X,ans);
        return ans[0];
    }

    public static void rec(TreeNode<Integer> node, int x, int[] ans){
        if(node == null) return;
        if(node.data == x ){
            ans[0] = node.data;
            return;
        }

        if(x < node.data){
            rec(node.left,x,ans);
        }
        else if(x > node.data){
            ans[0] = node.data;
            if(node.right == null) return;
            rec(node.right,x,ans);
        }
    }

    //do binary search using iteration : if(x < node.data) go left and node.data cannot be your ans,
    //if(x > node.data) node.data can be your potential ans so update ans[0]
    public static int floorInBSTSol2(TreeNode<Integer> root, int X) {
        int floor = 0;

        while(root != null){
            if(root.data == X) {
                floor = root.data;
                return floor;
            }

            if(X > root.data){
                floor = root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
