
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count the frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );

        for (int num : freq.keySet()) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Collect the k most frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
