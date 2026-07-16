/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        for (Interval i : intervals) {
            tmap.put(i.start, tmap.getOrDefault(i.start, 0) + 1);
            tmap.put(i.end, tmap.getOrDefault(i.end, 0) - 1);
        }
        
        int ans = 0;
        int cnt = 0;
        
        for (int timePoint : tmap.keySet()) {
            cnt += tmap.get(timePoint);
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}