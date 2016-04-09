package cn.console.tree.sub;

public class SubBinaryTree {
    public static int isSubTree(TNode root1, TNode root2) {
        if (root2 == null) {
            return 1;
        }

        if (root1 == null) {
            return -1;
        }

        if (root1.value == root2.value) {

            return ((isSubTree(root1.left, root2.left) == 1) && (isSubTree(
                    root1.right, root2.right) == 1)) == true ? 1 : -1;
        }

        else {

            return ((isSubTree(root1.left, root2) == 1) || (isSubTree(
                    root1.right, root2) == 1)) == true ? 1 : -1;
        }
    }
}
