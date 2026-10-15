
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: prerequisite -> course
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = completed
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
        int course,
        List<List<Integer>> graph,
        int[] state
    ) {
        if (state[course] == 1) {
            return true; // Cycle detected
        }

        if (state[course] == 2) {
            return false; // Already processed
        }

        state[course] = 1;

        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
