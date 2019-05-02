package cs203.project04;
import cs203.battlearena.util.TreeNode;

import java.util.Comparator;

public class BinaryTreeNode<T> implements TreeNode<T>{
    private T data;
    private TreeNode<T> right;
    private TreeNode<T> left;
    

    

    public BinaryTreeNode(T data) {
        this.data=data;
        this.right=null;
        this.left=null;
    }

    public T getData(){
        return this.data;
    }
    public TreeNode<T> getLeft(){
        return this.left;
    }

    public TreeNode<T> getRight(){
        return this.right;
    
    }

    public void setLeft(TreeNode<T> left){
            this.left=(BinaryTreeNode)left;
        
    
    }


    

    public void setRight(TreeNode<T> right){
        
            this.right=(BinaryTreeNode)right;
        
    }

}
