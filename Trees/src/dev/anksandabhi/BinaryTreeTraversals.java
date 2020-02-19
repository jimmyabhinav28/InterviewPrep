package dev.anksandabhi;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversals {


    public List<BinaryTreeNode> inorderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> result = new ArrayList<>();
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

        List<BinaryTreeNode> result = new ArrayList<>();
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

        List<BinaryTreeNode> result = new ArrayList<>();
        if (root.getLeft() != null)
            result.addAll(inorderTraversal(root.getLeft()));
        if (root.getRight() != null)
            result.addAll(inorderTraversal(root.getRight()));
        result.add(root);
        return result;
    }

    public List<BinaryTreeNode> levelorderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> result = new ArrayList<>();
        result.add(root);

        int currentIndex = 0;
//        Iterator<BinaryTreeNode> iterator=result.iterator();
        //iterator gave concurrent modification exception
        while (currentIndex != result.size()) {
            BinaryTreeNode currentNode = result.get(currentIndex);
            if (currentNode.getLeft() != null)
                result.add(currentNode.getLeft());

            if (currentNode.getRight() != null)
                result.add(currentNode.getRight());

            currentIndex++;
        }

        return result;
    }
}
