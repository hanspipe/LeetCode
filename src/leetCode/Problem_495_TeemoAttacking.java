package leetCode;

/*
 * 	Use two variable to record current start and end point.
	If the start of new interval is greater than current end, meaning NO overlapping, 
	we can sum the current interval length to result and then update start and end.
	Otherwise just update the current end;
 */
public class Problem_495_TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0)
			return 0;

		int start = timeSeries[0];
		int end = timeSeries[0] + duration;
		int time = 0;

		for (int i = 1; i < timeSeries.length; i++) {
			if (timeSeries[i] > end) {
				time += end - start;
				start = timeSeries[i];
			}
			end = timeSeries[i] + duration;
		}

		time += end - start;

		return time;
	}
}
