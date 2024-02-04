class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        List<int[]> merged = new ArrayList<>();

        int[] currInterval = intervals[0];

        for(int i=1;i<intervals.length;i++)
        {
            if(currInterval[1]>=intervals[i][0])
            {
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
                currInterval[0] = Math.min(currInterval[0],intervals[i][0]);
            }
            else
            {
                merged.add(currInterval);
                currInterval = intervals[i];
            }
        }
         merged.add(currInterval);
        int[][] result = new int[merged.size()][2];

        for(int i=0;i<merged.size();i++)
        {
            result[i] = merged.get(i);
        }
        return result;


    }
}