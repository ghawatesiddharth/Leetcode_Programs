class Solution {
    static class Node {
        char leftChar, rightChar;
        int leftLen, rightLen, best, len;
        Node() {}
        Node(char c) {
            leftChar = rightChar = c;
            leftLen = rightLen = best = len = 1;
        }
    }
    Node[] tree;
    char[] s;
    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        Node res = new Node();
        res.len = a.len + b.len;
        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;
        // Prefix
        res.leftLen = a.leftLen;
        if (a.leftLen == a.len && a.rightChar == b.leftChar) {
            res.leftLen = a.len + b.leftLen;
        }
        // Suffix
        res.rightLen = b.rightLen;
        if (b.rightLen == b.len && a.rightChar == b.leftChar) {
            res.rightLen = b.len + a.rightLen;
        }
        res.best = Math.max(a.best, b.best);
        if (a.rightChar == b.leftChar) {
            res.best = Math.max(res.best,
                    a.rightLen + b.leftLen);
        }
        return res;
    }
    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(s[l]);
            return;
        }
        int mid = l + (r - l) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            tree[node] = new Node(c);
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(node * 2, l, mid, idx, c);
        } 
        else {
            update(node * 2 + 1, mid + 1, r, idx, c);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    public int[] longestRepeating(String s,String queryCharacters,int[] queryIndices) {
        this.s = s.toCharArray();
        int n = s.length();
        int k = queryIndices.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            this.s[idx] = c;
            update(1, 0, n - 1, idx, c);
            ans[i] = tree[1].best;
        }
        return ans;
    }
}