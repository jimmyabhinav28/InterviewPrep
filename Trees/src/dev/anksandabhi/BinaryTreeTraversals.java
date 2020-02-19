package dev.anksandabhi;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

    public TreeMap<Integer, ArrayList<BinaryTreeNode>> verticalOrderTraversal(BinaryTreeNode root) {
        TreeMap<Integer, ArrayList<BinaryTreeNode>> verticalOrderTraversalResult = new TreeMap<>();

        verticalOrderTraversal(root, verticalOrderTraversalResult, 0);

        return verticalOrderTraversalResult;
    }

    private void verticalOrderTraversal(BinaryTreeNode root, TreeMap<Integer, ArrayList<BinaryTreeNode>> verticalLevelMap, Integer verticalLevel) {
        if (root == null)
            return;
        if (verticalLevelMap.get(verticalLevel) == null) {
            ArrayList<BinaryTreeNode> listAtThisVerticalLevel = new ArrayList<>();
            listAtThisVerticalLevel.add(root);
            verticalLevelMap.put(verticalLevel, listAtThisVerticalLevel);
        } else {
            ArrayList<BinaryTreeNode> listAtThisVerticalLevel = verticalLevelMap.get(verticalLevel);
            listAtThisVerticalLevel.add(root);
            verticalLevelMap.put(verticalLevel, listAtThisVerticalLevel);
        }

        verticalOrderTraversal(root.getLeft(), verticalLevelMap, verticalLevel - 1);
        verticalOrderTraversal(root.getRight(), verticalLevelMap, verticalLevel + 1);
    }
}
