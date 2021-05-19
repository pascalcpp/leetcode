package com.xpcf.algorithm;


/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
//        while (!deque.isEmpty()) {
//            TreeNode pop = deque.pop();
//            ans.add(pop.val);
//            if (pop.right != null) {
//                deque.push(pop.right);
//            }
//
//            if (pop.left != null) {
//                deque.push(pop.left);
//            }
//        }
//        return ans;
//    }
//
//    public List<Integer> preorderTraversal2(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        TreeNode node = root;
//        while (true) {
//
//            if (node != null) {
//                ans.add(node.val);
//                if (node.right != null) {
//                    deque.push(node.right);
//                }
//                node = node.left;
//            } else if (deque.isEmpty()) {
//                return ans;
//            } else {
//                node = deque.pop();
//            }
//        }
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        TreeNode node = root;
//        while (true) {
//            if (node != null) {
//                deque.push(node);
//                node = node.left;
//            } else if(deque.isEmpty()) {
//                return ans;
//            } else {
//                node = deque.pop();
//                ans.add(node.val);
//                node = node.right;
//            }
//        }
//    }
//
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
//        TreeNode prev = null;
//        while (!deque.isEmpty()) {
//            TreeNode node = deque.peek();
//            if ((node.left == null && node.right == null) || (prev != null && (node.left == prev || node.right == prev))) {
//                prev = deque.pop();
//                ans.add(prev.val);
//            } else {
//                if (node.right != null) {
//                    deque.push(node.right);
//                }
//                if (node.left != null) {
//                    deque.push(node.left);
//                }
//            }
//        }
//        return ans;
//    }
//
//
//    public List<Integer> postorderTraversal2(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root == null) {
//            return ans;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        TreeNode prev = null;
//        while (root != null || !deque.isEmpty()) {
//
//            while (root != null) {
//                deque.push(root);
//                root = root.left;
//            }
//
//            root = deque.peek();
//            if (root.right == null || prev == root.right) {
//                prev = deque.pop();
//                ans.add(prev.val);
//                root = null;
//            } else {
//                root = root.right;
//            }
//
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 2, 2},
                {2, 2, 2}
        };
        System.out.println();
    }


}
