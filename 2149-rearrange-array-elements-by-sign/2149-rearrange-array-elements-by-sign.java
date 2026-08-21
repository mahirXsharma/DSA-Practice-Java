class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int posIdx = 0, negIdx = 1;
        for(int  num : nums){
            if(num > 0){
                ans[posIdx] = num;
                posIdx  += 2;
            }
            else{
                ans[negIdx] = num;
                negIdx += 2;
            }
        }
        return ans;





        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        // for(int num : nums){
        //     if(num > 0) l1.add(num);
        //     else l2.add(num);
        // }
        // int ans[] = new int[nums.length];
        // int size = l1.size();
        // int k=0;
        // for(int i=0; i<size; i++){
        //     ans[k++] = l1.get(i);
        //     ans[k++] = l2.get(i);
        // }
        // return ans;
    }
}