package dev.anksandabhi;

public class Main {

    public static void main(String[] args) {

//        testInorderRecursive();
//        testPreorderRecursive();
//        testPostorderRecursive();

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

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

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
}
