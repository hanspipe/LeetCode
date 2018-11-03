package leetCode;
/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: Given an array of numbers nums, 
 * 
 * in which exactly two elements appear only once and all the other elements appear exactly twice.
 * 
 *  Find the two elements that appear only once.</p>
 */
public class Problem_260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
