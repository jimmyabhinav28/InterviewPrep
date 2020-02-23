package dev.anksandabhi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    /**
     * changes a binary tree to a linked list and returns it's head
     * @param root
     * @return
     */

    public static BinaryTreeNode flattenBinaryTreeInPlace(BinaryTreeNode root)
    {
        if(root==null)
            return null;
        if(root.getLeft()!=null && root.getRight()!=null)
        if(isNodeALeafNode(root.getLeft()) && isNodeALeafNode(root.getRight()))
        {
            BinaryTreeNode rightChild=root.getRight();
            BinaryTreeNode leftChild=root.getLeft();
            root.setRight(leftChild);
            leftChild.setLeft(null);
            leftChild.setRight(rightChild);
            root.setLeft(null);
            return root;
        }
        BinaryTreeNode leftSubTreeFlattened=flattenBinaryTreeInPlace(root.getLeft());
        BinaryTreeNode rightSubTreeFlattened=flattenBinaryTreeInPlace(root.getRight());

        root.setLeft(null);
        root.setRight(leftSubTreeFlattened);

        if(leftSubTreeFlattened!=null) {
            while (leftSubTreeFlattened.getRight() != null) {
                leftSubTreeFlattened = leftSubTreeFlattened.getRight();
            }
            leftSubTreeFlattened.setRight(rightSubTreeFlattened);
        }
        else
        {
            root.setRight(rightSubTreeFlattened);
        }
        return root;
    }

    private static boolean isNodeALeafNode(BinaryTreeNode node)
    {

        if(node.getLeft()==null && node.getRight()==null)
            return true;
        return false;
    }

}
