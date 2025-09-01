
public class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= currentInterval[1]) { // Overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }
             else { // No overlap
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}