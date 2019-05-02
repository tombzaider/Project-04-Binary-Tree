package cs203.project04;
import cs203.battlearena.util.TreeNode;
import cs203.battlearena.util.Tree;



import java.util.Comparator;
import java.util.NoSuchElementException;


public class BinaryTree<T> implements Tree<T> {
    private TreeNode<T> root;
    private Comparator<T> comp;
    private int numElements;

    public BinaryTree(Comparator<T> comparator) {
        this.comp=comparator;
        this.root=null;
        this.numElements=0;
    }

    public boolean hiddenInsert(TreeNode<T> node,T element) {
        
        if (comp.compare(element,node.getData())==1 || comp.compare(element,node.getData())==0){
            if (node.getRight()==null) {node.setRight(new BinaryTreeNode<>(element)); numElements++; return true;}
            else{ return hiddenInsert(node.getRight(),element);}
        }
        
        else {
            if (node.getLeft()==null) {node.setLeft(new BinaryTreeNode<>(element)); numElements++; return true;}
            
            else { return hiddenInsert(node.getLeft(), element);}

        
        } 
    }

   

    public boolean insert(T element) {
        if (this.root==null) {
            this.root= new BinaryTreeNode<>(element);
            this.numElements++;
            return true;
        }
        return hiddenInsert(this.root,element);}
        
    

    public boolean isEmpty() {
        if (this.root==null) {
            return true;
        }
        else {
            return false;
        }
    }

    private T hiddenLower(TreeNode<T> node, T element) {
        //greatest, but lower than element
        if (this.isEmpty()) {
            return null;
        }
        if (node==null) {return null;}

        if (comp.compare(node.getData(), element)== 1 || comp.compare(element,node.getData())==0) {
            if (node.getLeft()==null) {
            return null; }
            else { hiddenLower(node.getLeft(),element);}
        }
        
        else if (comp.compare(node.getData(),element)==-1)
        {
            if (node.getRight()==null)
            {return node.getData();}

            else if (comp.compare(node.getRight().getData(),element)!=-1){
                return node.getData();
            }
        }
        
        
        return hiddenLower(node.getRight(), element);
         
        
    }

    public void clear() {
        this.root=null;
        this.numElements=0;
    }

    

    
    public T lower(T element) {
        return hiddenLower(this.root, element);
    }

    public T hiddenHigher(TreeNode<T> node, T element) {
         //smallest, but higher than given element
         if (this.isEmpty()) {
            return null;
        }

        else if (comp.compare(node.getData(),element)==-1 || comp.compare(element,node.getData())==0) {
            if (node.getRight()==null){
            return null; }
            else {return hiddenHigher(node.getRight(),element);}
        }
        else if (comp.compare(node.getData(),element)==1)
        { if (node.getLeft()==null)
        {
         return node.getData();   
        }
        else if (comp.compare(node.getLeft().getData(),element)!=1) {
            return node.getData();
        }
        }
        
        return hiddenHigher(node.getLeft(), element);
         
    }

    private T hiddenFirst(TreeNode<T> node) {
        

        if (node.getLeft()==null) {
            return node.getData(); 
        }

        else {
            return hiddenFirst(node.getLeft());
        } 

    }

    public T higher(T element) {
        return hiddenHigher(this.root,element);
    }

    public T first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return hiddenFirst(this.root);
    }

    private T hiddenLast(TreeNode<T> node) {
        if (node.getRight()==null) {
            return node.getData();
        }

        else {
            return hiddenLast(node.getRight());
        }
        
    } 

    public T last() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return hiddenLast(this.root);
    }

    private boolean hiddenContains(TreeNode<T> node,T element) {
        
        if (node==null) {return false;}

        else if (comp.compare(node.getData(),element)==0 ) {
            return true;
        }

        else {
            if (comp.compare(element,node.getData())==1) {
                return hiddenContains(node.getRight(), element);
            }
            else { return hiddenContains(node.getLeft(), element);}
        }
    

}

    public boolean contains(T element) {
        if (this.isEmpty()) {
            return false;
        }

        return hiddenContains(this.root, element);
    } 

    
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return numElements;
    }

    public String toString() {
        return this.root.getData().toString();
    }

        
    }
