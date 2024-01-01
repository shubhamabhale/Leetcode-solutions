import java.util.HashMap;
import java.util.Map;

class TwoSum {
    private Map<Integer, Integer> countMap;

    public TwoSum() {
        countMap = new HashMap<>();
    }

    public void add(int number) {
        countMap.put(number, countMap.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int complement = value - entry.getKey();
            if ((complement == entry.getKey() && entry.getValue() > 1) ||
                (complement != entry.getKey() && countMap.containsKey(complement))) {
                return true;
            }
        }
        return false;
    }
}
