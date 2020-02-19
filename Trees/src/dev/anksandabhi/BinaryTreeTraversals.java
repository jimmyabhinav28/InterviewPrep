package dev.anksandabhi;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversals {


    public List<BinaryTreeNode> inorderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> result=new ArrayList<>();
        if (root.getLeft() != null)
            result.addAll(inorderTraversal(root.getLeft()));
        result.add(root);
        if (root.getRight() != null)
            result.addAll(inorderTraversal(root.getRight()));
        return result;
    }

    public List<BinaryTreeNode> preorderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> result=new ArrayList<>();
        result.add(root);
        if (root.getLeft() != null)
            result.addAll(inorderTraversal(root.getLeft()));
        if (root.getRight() != null)
            result.addAll(inorderTraversal(root.getRight()));
        return result;
    }

    public List<BinaryTreeNode> postorderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> result=new ArrayList<>();
        if (root.getLeft() != null)
            result.addAll(inorderTraversal(root.getLeft()));
        if (root.getRight() != null)
            result.addAll(inorderTraversal(root.getRight()));
        result.add(root);
        return result;
    }
}
