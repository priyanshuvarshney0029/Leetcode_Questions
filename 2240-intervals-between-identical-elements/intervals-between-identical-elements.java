class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] res = new long[n];

        // Step 1: Map from value -> list of indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            long[] prefix = new long[m];  // same size as group, starts from 0

            // Build prefix sum of indices
            prefix[0] = indices.get(0);
            for (int i = 1; i < m; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }

            // Step 3: For each index in the group, calculate contribution
            for (int i = 0; i < m; i++) {
                int idx = indices.get(i);
                // ✅ Fix is here
                long leftsum = (i > 0) ? prefix[i - 1] : 0;
                long rightsum = prefix[m - 1] - prefix[i];
                long left_con = (long) indices.get(i)*i-leftsum;
                long right_con = rightsum - (long) indices.get(i) * (m - i - 1);

                res[idx] = left_con + right_con;
            }
        }

        return res;
    }
}
