class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        String t = "1" + s + "1";
        ArrayList<int[]> store = new ArrayList<>();
        int i = 0;
        while (i < t.length()) {
            char current = t.charAt(i);
            int length = 0;

            while (i < t.length() && t.charAt(i) == current) {
                length++;
                i++;
            }

            store.add(new int[]{current - '0', length});
        }
        int maxGain = 0;
        for (int a = 1; a < store.size() - 1; a++) {
            int[] left = store.get(a - 1);
            int[] mid = store.get(a);
            int[] right = store.get(a + 1);
            if (left[0] == 0 && mid[0] == 1 && right[0] == 0) {
                int gain = left[1] + right[1];
                maxGain = Math.max(maxGain, gain);
            }
        }
        return ones + maxGain;
    }
}