class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        final int MAX = 2048;   
        boolean[][] pair = new boolean[n + 1][MAX];
        boolean[] cur = new boolean[MAX];

        for (int j = n - 1; j >= 0; j--) {
            boolean[] next = cur.clone();

            for (int k = j; k < n; k++) {
                next[nums[j] ^ nums[k]] = true;
            }

            pair[j] = next;
            cur = next;
        }

        boolean[] ans = new boolean[MAX];

        for (int i = 0; i < n; i++) {
            for (int x = 0; x < MAX; x++) {
                if (pair[i][x]) {
                    ans[nums[i] ^ x] = true;
                }
            }
        }

        int cnt = 0;
        for (boolean v : ans) {
            if (v) cnt++;
        }
        return cnt;
    }
}