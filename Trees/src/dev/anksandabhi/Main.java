package dev.anksandabhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

//        testInorderRecursive();
//        testPreorderRecursive();
//        testPostorderRecursive();
//        testLevelOrder();
//        testIfTreesAreIdentical();
//        testVerticalOrderTraversal();
        testFlattenBinaryTree();
    }

    private static BinaryTreeNode<Integer> getIntegerBinaryTree()
    {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>();
        root.setValue(0);
        BinaryTreeNode<Integer> node1=new BinaryTreeNode<>();
        node1.setValue(1);
        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>();
        node2.setValue(2);
        BinaryTreeNode<Integer> node3=new BinaryTreeNode<>();
        node3.setValue(3);
        BinaryTreeNode<Integer> node4=new BinaryTreeNode<>();
        node4.setValue(4);
        BinaryTreeNode<Integer> node5=new BinaryTreeNode<>();
        node5.setValue(5);
        BinaryTreeNode<Integer> node6=new BinaryTreeNode<>();
        node6.setValue(6);

        root.setLeft(node1);
        root.setRight(node2);

        //node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        return root;

    }


    private static BinaryTreeNode<Integer> getIntegerBinaryTree1()
    {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>();
        root.setValue(0);
        BinaryTreeNode<Integer> node1=new BinaryTreeNode<>();
        node1.setValue(1);
        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>();
        node2.setValue(2);
        BinaryTreeNode<Integer> node3=new BinaryTreeNode<>();
        node3.setValue(3);
        BinaryTreeNode<Integer> node4=new BinaryTreeNode<>();
        node4.setValue(4);
        BinaryTreeNode<Integer> node5=new BinaryTreeNode<>();
        node5.setValue(5);
        BinaryTreeNode<Integer> node6=new BinaryTreeNode<>();
        node6.setValue(6);
        BinaryTreeNode<Integer> node7=new BinaryTreeNode<>();
        node6.setValue(7);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        node2.setLeft(node7);
        return root;

    }
    private static void testInorderRecursive()
    {
        BinaryTreeTraversals traversal=new BinaryTreeTraversals();
        System.out.println(traversal.inorderTraversal(getIntegerBinaryTree()));
    }

    private static void testPreorderRecursive()
    {
        BinaryTreeTraversals traversal=new BinaryTreeTraversals();
        System.out.println(traversal.preorderTraversal(getIntegerBinaryTree()));
    }

    private static void testPostorderRecursive()
    {
        BinaryTreeTraversals traversal=new BinaryTreeTraversals();
        System.out.println(traversal.postorderTraversal(getIntegerBinaryTree()));
    }

    private static void testLevelOrder()
    {
        BinaryTreeTraversals traversal=new BinaryTreeTraversals();
        System.out.println(traversal.levelorderTraversal(getIntegerBinaryTree()));
    }

    private static void testIfTreesAreIdentical()
    {
        BinaryTreeNode tree1=getIntegerBinaryTree();
        BinaryTreeNode tree2=getIntegerBinaryTree1();
        System.out.println(Trees1.areTreesIdentical(tree1,tree2));
    }

    private static void testVerticalOrderTraversal()
    {
        BinaryTreeTraversals traversal=new BinaryTreeTraversals();
        BinaryTreeNode tree1=getIntegerBinaryTree();
        TreeMap<Integer, ArrayList<BinaryTreeNode>> result =traversal.verticalOrderTraversal(tree1);
        for(Integer i: result.keySet())
        {
            System.out.println(result.get(i));
        }
    }


    private static void testFlattenBinaryTree()
    {
        BinaryTreeNode tree1=getIntegerBinaryTree();
        tree1=Trees1.flattenBinaryTreeInPlace(tree1);
        BinaryTreeNode root=tree1;
        while(root!=null)
        {
            System.out.println(root.getValue());
            root=root.getRight();
        }

        System.out.println("done");
    }

}
