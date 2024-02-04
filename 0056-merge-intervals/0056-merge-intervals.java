class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();

        int[] currInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currInterval[1] >= intervals[i][0]) {
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            } else {
                merged.add(currInterval);
                currInterval = intervals[i];
            }
        }

        merged.add(currInterval);

        int[][] result = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}
