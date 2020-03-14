package dev.anksandabhi;


import java.util.List;

public class BinaryTreeFromTraversalResult {

    public BinaryTreeNode getBinaryTreeGivenInorderTraversal(List<BinaryTreeNode> inorderTraversalResult)
    {
        BinaryTreeNode root=new BinaryTreeNode<>();
        return root;
    }

    public BinaryTreeNode getBinaryTreeGivenInorderAndPostOrderTraversal(List<BinaryTreeNode> postOrderTraversalResult, List<BinaryTreeNode> inorderTraversalResult) throws Exception {
        if(inorderTraversalResult.size()!=postOrderTraversalResult.size())
            throw new Exception("invalid input");

        if(inorderTraversalResult.size()==1)
            return inorderTraversalResult.get(0);

        BinaryTreeNode root=postOrderTraversalResult.get(postOrderTraversalResult.size()-1);
        //find the root in the inorder traversal now
        int pointerPosition=0;
        while(!inorderTraversalResult.get(pointerPosition).equals(root))
            pointerPosition++;
        List<BinaryTreeNode> leftSubtreeInOrder=null;
        List<BinaryTreeNode> rightSubtreeInOrder=null;

        if (pointerPosition!=0)
        {
            leftSubtreeInOrder=inorderTraversalResult.subList(0,pointerPosition); //sublist is right exclusive
        }
        if(inorderTraversalResult.size()-1>pointerPosition)
            rightSubtreeInOrder=inorderTraversalResult.subList(pointerPosition+1, inorderTraversalResult.size());

        List<BinaryTreeNode> leftSubtreePostOrder=null;
        List<BinaryTreeNode> rightSubtreePostOrder=null;

        //you know the left tree and right subtree from the inorder traversal now
        //in  the post order traversal as well, left subtree elements will occur together and right subtree elements will
        //occur together
        //in post order, the last element of the right subtree will occur just before the root
        //left subtree elements will occur before it, and all left subtree elements will occur before the last element of the left subtree



    }

    public BinaryTreeNode getBinaryTreeGivenInorderAndPreOrderTraversal(List<BinaryTreeNode> preorderTraversalResult,List<BinaryTreeNode> postorderTraversalResult)
    {
        BinaryTreeNode root=new BinaryTreeNode<>();
        return root;
    }

    public BinaryTreeNode getBinaryTreeGivenPreOrderAndPostOrderTraversal(List<BinaryTreeNode> preorderTraversalResult,List<BinaryTreeNode> postorderTraversalResult)
    {
        BinaryTreeNode root=new BinaryTreeNode<>();
        return root;
    }

}
