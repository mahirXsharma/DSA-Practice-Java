class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort acc to the end time 
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        int count = 0;
        int n = intervals.length;
        int prevEnd = intervals[0][1];

        for(int i=1; i<n; i++){
            if(prevEnd > intervals[i][0]){
                // remove
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}