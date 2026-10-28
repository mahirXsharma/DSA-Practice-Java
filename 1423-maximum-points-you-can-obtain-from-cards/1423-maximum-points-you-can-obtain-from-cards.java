class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // k*k
        int n = cardPoints.length;
        int sum = 0, leftSum = 0, rightSum = 0;
        for (int i = 0; i < k; i++)
            leftSum += cardPoints[i];
        sum = leftSum;

        for (int i = k - 1; i >= 0; i--) {

            leftSum = leftSum - cardPoints[i];
            rightSum += cardPoints[n- (k - i)];
            int currSum = leftSum + rightSum;
            if (currSum > sum)
                sum = currSum;
        }
        return sum;
    }
}