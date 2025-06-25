class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = -10000000001L;
        long hi = 10000000001L;
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (count_product(nums1, nums2, mid) >= k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static long count_product(int[] nums1, int[] nums2, long dot_product) {
        long ans = 0;
        for (int ei : nums1) {
            if (ei >= 0) {
                int lo = 0, hi = nums2.length - 1, c = 0;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if ((long) ei * nums2[mid] <= dot_product) {
                        c = mid + 1;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                ans += c;
            } else {
                int lo = 0, hi = nums2.length - 1, c = 0;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if ((long) ei * nums2[mid] <= dot_product) {
                        c = nums2.length - mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                ans += c;
            }
        }
        return ans;
    }
}
