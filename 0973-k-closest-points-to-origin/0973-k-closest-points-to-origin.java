class Solution {
    
    class Point implements Comparable<Point>
    {
        public double dist;
        public int x, y;
        Point(int x, int y, double dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Point temp)
        {
            if(this.dist>=temp.dist)
            {
                return 1;
            }
            return -1;
        }
    }
    public double getDist(int x, int y)
    {
        return Math.sqrt(x*x + y*y);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int[] point: points)
        {
            double temp = getDist(point[0], point[1]);
            pq.add(new Point(point[0],point[1], temp));
        }
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++)
        {
            Point temp = pq.poll();
            // int[] arr = new int[2];
            // arr[0] = temp.x;
            // arr[1]=temp.y;
            result[i][0] = temp.x;
            result[i][1] = temp.y;
        }
        return result;
    }
}