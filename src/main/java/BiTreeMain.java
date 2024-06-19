/**
 * @author tim
 * @date 2024/5/23
 */

import java.util.*;

public class BiTreeMain {
    static int index = 0;

    public static void main(String[] args) {


        // 层序遍历构建二叉树
        Integer[] treeLayer = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode rootLayer = constructTreeByLayer(treeLayer);
        ArrayList<Integer> listLayer = inorder(rootLayer);
        listLayer.forEach(node -> System.out.print(node + " "));




        System.out.println("\n###########################");

        // 先序遍历构建二叉树
        Integer[] treePre = new Integer[]{1, 2, 4, null, null, 5, null, null, 3, null, 6, 7, null, null, null};
        TreeNode rootPre = constructTreeByPre(treePre);
        ArrayList<Integer> listPre = inorder(rootPre);
        listPre.forEach(node -> System.out.print(node + " "));

    }




    /**
     * 先序遍历构建二叉树
     *
     * @param arr
     * @return
     */
    private static TreeNode constructTreeByPre(Integer[] arr) {
        if (arr == null || index >= arr.length || arr[index] == null) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(arr[index++]);
        node.left = constructTreeByPre(arr);
        node.right = constructTreeByPre(arr);
        return node;
    }


    /**
     * 层序遍历构建二叉树
     *
     * @param array
     * @return
     */
    public static TreeNode constructTreeByLayer(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                if (i < array.length && array[i] != null) {
                    currentNode.left = new TreeNode(array[i]);
                    queue.offer(currentNode.left);
                }
                i++;

                if (i < array.length && array[i] != null) {
                    currentNode.right = new TreeNode(array[i]);
                    queue.offer(currentNode.right);
                }
                i++;
            }
        }

        return root;
    }


    /**
     * 中序遍历二叉树
     * 迭代栈模拟递归
     *
     * @param root
     * @return
     */
    private static ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     *
     * 中序遍历二叉树
     * Morris 遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        while (root != null) {
            if (root.left == null) {
                list.add(root.val);
                root = root.right;
            } else {
                // pre 为 root 的前驱节点，也就是左子树中的最右节点
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    // 第一次找到前驱
                    pre.right = root;
                    root = root.left;
                } else {
                    // 第二次遍历到前驱，说明root的左子树已经全部遍历完毕
                    // 遍历 root
                    // 再开始右子树
                    pre.right = null;
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

