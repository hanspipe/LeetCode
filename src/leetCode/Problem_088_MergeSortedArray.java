package leetCode;

//Given two sorted integer arrays nums1 and nums2, 
//merge nums2 into nums1 as one sorted array.

//The number of elements initialized in nums1 and nums2 are m and n respectively.
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
public class Problem_088_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 两个数组的元素个数
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		// 从后往前
		while (j >= 0) {
			nums1[k--] = i < 0 || nums2[j] > nums1[i] ? nums2[j--] : nums1[i--];
		}
	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		// 如果两个数组中的元素都还没有遍历完
		while(i >= 0 && j >= 0)
		{
			// nums1从后往前，较大值填充
			nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--]; 
		}
		
		// 如果nums2还没有遍历完，就把nums2剩下的全部填完
		while(j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
