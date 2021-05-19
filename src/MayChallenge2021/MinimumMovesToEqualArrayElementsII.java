package MayChallenge2021;

import java.util.Arrays;

/**
 @author :
 Gaurav Kaushik
 https://leetcode.com/kaushikgaurav08/
 https://www.linkedin.com/in/gvk28/
 https://github.com/gauravkaushik

 https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

 */
public class MinimumMovesToEqualArrayElementsII {

    //a better solution shared by leetcode.
    //Time : O(NlogN) for sorting. Space: O(1)
    public int minMoves2(int[] nums) {
        int l = 0, r = nums.length - 1, sum = 0;
        Arrays.sort(nums);
        while (l < r) {
            // Since we need to make both nums[l] and nums[r] equal to some middle value K,
            // total moves needed would be ( K - nums[l] ) + ( num[r] - K)
            // which adds up to nums[r] - nums[l] as K and -K cancel each other.
            sum += nums[r] - nums[l];
            l++;
            r--;
        }
        return sum;
    }

    // my brute force solution : Time : O(N^2); Space : O(1)
    public int minMoves2_bruteforce(int[] nums) {
        int minMoves = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int moves = 0;
            for(int j = 0; j < nums.length; j++) {
                if(moves > minMoves) {
                    break;
                }
                int diff = Math.abs(target - nums[j]);
                if(moves > Integer.MAX_VALUE - diff) {
                    moves = Integer.MAX_VALUE;
                    break;
                }
                moves += diff;
            }
            minMoves = Math.min(moves, minMoves);
        }

        return minMoves;
    }

}
