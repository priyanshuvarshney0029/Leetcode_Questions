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
                long leftSum = (i > 0) ? (long) indices.get(i) * i - prefix[i - 1] : 0;
                long rightSum = (i < m - 1) ? (prefix[m - 1] - prefix[i]) - (long) indices.get(i) * (m - i - 1) : 0;
                res[idx] = leftSum + rightSum;
            }
        }

        return res;
    }
}