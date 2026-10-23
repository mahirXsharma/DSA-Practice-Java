class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int size = n1+n2;
        int p1 = 0, p2 = 0, count = 0;
        int idx1 = size/2 -1, idx2 = size/2;
        int left = 0, right = 0;

        while(p1 < n1 && p2 < n2){
            int curr = 0;
            if(nums1[p1] < nums2[p2]){
                curr = nums1[p1++];
            }
            else {
                curr = nums2[p2++];
            }

            count++;
            if(count-1 == idx1) left = curr;
            if(count-1 == idx2) right = curr;
        }
        while( p1 < n1){
            int curr = nums1[p1++];
            count++;
            if(count -1 == idx1) left = curr;
            if(count -1 == idx2) right = curr;

        }

        while(p2 < n2){
            int curr = nums2[p2++];
            count++;
            if(count -1 == idx1) left = curr;
            if(count -1 == idx2) right = curr; 
        }
        
        return size%2 == 0 ? (left +right)/2.0 : right;
    }
}