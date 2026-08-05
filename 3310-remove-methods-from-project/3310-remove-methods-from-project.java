class Solution {
    List<Integer>[] graph;
    List<Integer>[] rev;
    boolean[] vis;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph = new ArrayList[n];
        rev = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            rev[v].add(u);
        }

        dfs(k);

        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                for (int parent : rev[i]) {
                    if (!vis[parent]) {
                        List<Integer> ans = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            ans.add(j);
                        }
                        return ans;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node) {
        vis[node] = true;

        for (int nei : graph[node]) {
            if (!vis[nei]) {
                dfs(nei);
            }
        }
    }
}