class SnapshotArray {
    TreeMap<Integer, Integer>[] graph;
    int snapshot;
    public SnapshotArray(int length) {
        graph = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            graph[i] = new TreeMap<>();
            graph[i].put(0,0);
        }
        snapshot=0;
    }
    
    public void set(int index, int val) {
        graph[index].put(snapshot, val);
    }
    
    public int snap() {
        
        return snapshot++;
    }
    
    public int get(int index, int snap_id) {
        return graph[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */