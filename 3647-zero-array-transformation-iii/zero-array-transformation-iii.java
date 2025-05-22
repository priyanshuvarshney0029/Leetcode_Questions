class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int sz = queries.length;

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dif = new int[n];
        int j = 0, cnt = 0, sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            while (j < sz && queries[j][0] <= i) {
                pq.offer(queries[j][1]);
                j++;
            }

            if (i > 0) dif[i] += dif[i - 1];
            sum = dif[i];

            while (sum < nums[i]) {
                if (pq.isEmpty()) return -1;

                int a = pq.poll();

                if (a >= i) {
                    dif[i]++;
                    if (a + 1 < n) dif[a + 1]--;
                    sum++;
                    cnt++;
                }
            }
        }

        return sz - cnt;
    }
}
