
import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {

    // Max heap: stores the smaller half
    private PriorityQueue<Integer> small;

    // Min heap: stores the larger half
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        // Keep small equal in size to large,
        // or one element larger
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }

        return ((double) small.peek() + large.peek()) / 2.0;
    }
}
