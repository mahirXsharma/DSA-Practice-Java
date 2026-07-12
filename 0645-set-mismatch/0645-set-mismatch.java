class Solution {
    public int[] findErrorNums(int[] nums) {
        long n = nums.length;
        
        // 1. Calculate the expected sums using standard math formulas
        long expectedSum = (n * (n + 1)) / 2;
        long expectedSqSum = (n * (n + 1) * (2 * n + 1)) / 6;
        
        long actualSum = 0;
        long actualSqSum = 0;
        
        // 2. Calculate the actual sums from our array
        for (int num : nums) {
            actualSum += num;
            actualSqSum += (long) num * num;
        }
        
        // 3. diff1 = Missing (y) - Duplicate (x)
        long diff1 = expectedSum - actualSum;
        
        // 4. diff2 = Missing^2 (y^2) - Duplicate^2 (x^2)
        long diff2 = expectedSqSum - actualSqSum;
        
        // 5. Using algebra: (y^2 - x^2) / (y - x) = (y + x)
        long sumXY = diff2 / diff1; 
        
        // 6. Now we have two simple equations:
        // y - x = diff1
        // y + x = sumXY
        // Add them together: 2y = diff1 + sumXY
        long missing = (diff1 + sumXY) / 2;
        long duplicate = missing - diff1;
        
        return new int[]{(int) duplicate, (int) missing};
    }
}