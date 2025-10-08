/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex;

    public Node constructTree(int[] pre, int[] post) {
        preIndex = 0;
        return build(pre, post, 0, post.length - 1);
    }

    private Node build(int[] pre, int[] post, int l, int h) {
        if (preIndex >= pre.length || l > h)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == h || preIndex >= pre.length)
            return root;

        int i = l;
        while (i <= h && post[i] != pre[preIndex]) i++;

        if (i <= h) {
            root.left = build(pre, post, l, i);
            root.right = build(pre, post, i + 1, h - 1);
        }

        return root;
    }
}
