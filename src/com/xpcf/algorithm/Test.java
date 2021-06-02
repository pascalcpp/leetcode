package com.xpcf.algorithm;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<Integer> ints = Arrays.asList(1, 6, 4, 2, 3, 5, 6, 9, 8, 7, 0);
        ints.stream().filter(x -> x % 2 == 0).forEach(System.out::print); // 遍历输出符合条件的元素
        System.out.println("\n----");
        Optional<Integer> first = ints.stream().filter(x -> x % 2 == 0).findFirst();// 匹配第一个
        for (int i = 0; i < 10; i++) {
            ints.parallelStream().filter(x -> x % 2 == 0).findAny().ifPresent(s -> System.out.println(s));
        }
//        boolean single = ints.stream().filter(x -> x > 6).anyMatch(x -> x % 2 == 1);
//
//        System.out.println("匹配第一个值：" + first.get());
//        System.out.println("匹配任意一个值：" + any.get());
//        System.out.println("集合中，大于6的元素里是否存在大于6的值：" + single);
    }


}
