package leetCode;

/*
 * 	Use two variable to record current start and end point.
	If the start of new interval is greater than current end, meaning NO overlapping, 
	we can sum the current interval length to result and then update start and end.
	Otherwise just update the current end;
	
	Input: [1,4], 2
	Output: 4
	Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately. 
	This poisoned status will last 2 seconds until the end of time point 2. 
	And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds. 
	So you finally need to output 4.
 */
public class Problem_495_TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0)
			return 0;

		// ���ι�����ʼʱ��
		int start = timeSeries[0];
		// ���ι�������ʱ��
		int end = timeSeries[0] + duration;
		int time = 0;

		for (int i = 1; i < timeSeries.length; i++) {
			// ������ι�����ʼʱ������ϴν���ʱ��,û���غ�
			if (timeSeries[i] > end) {
				time += end - start;
				// ���¿�ʼʱ��
				start = timeSeries[i];
			}
			// ������ʱ��������,��ʼʱ��Ҳ������
			// ���±��ι�������ʱ��
			end = timeSeries[i] + duration;
		}
		// ���һ��
		time += end - start;

		return time;
	}
}
