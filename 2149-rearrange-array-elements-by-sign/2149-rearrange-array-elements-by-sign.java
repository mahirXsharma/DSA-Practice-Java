class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int num : nums){
            if(num > 0) l1.add(num);
            else l2.add(num);
        }
        int ans[] = new int[nums.length];
        int size = l1.size();
        int k=0;
        for(int i=0; i<size; i++){
            ans[k++] = l1.get(i);
            ans[k++] = l2.get(i);
        }
        return ans;
    }
}