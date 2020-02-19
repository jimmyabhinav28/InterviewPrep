package dev.anksandabhi;

public class Trees1 {

    public static<T extends BinaryTreeNode> boolean areTreesIdentical(BinaryTreeNode<T> treeRoot1,BinaryTreeNode<T> treeRoot2 )
    {
        //we will go preorder and compare the two trees.
        //remember that the comparison should be done while traversal itself, because the same preorder
        //traversal final result can occur in trees with different topologies

        if(treeRoot1==null && treeRoot2!=null)
            return false;
        if(treeRoot1!=null && treeRoot2==null)
            return false;

        //preorder starts
        if(treeRoot1==null && treeRoot2==null)
            return true;

        if(!treeRoot1.equals(treeRoot2))
            return false;
        boolean isLeftSubtreeIdentical=areTreesIdentical(treeRoot1.getLeft(),treeRoot2.getLeft());
        boolean isRightSubtreeIdentical=areTreesIdentical(treeRoot1.getRight(),treeRoot2.getRight());
        return (isLeftSubtreeIdentical&&isRightSubtreeIdentical);
    }
}
