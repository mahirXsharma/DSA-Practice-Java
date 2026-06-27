class Solution {
    
    
    public String frequencySort(String s) {
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        int[] arr = new int[128];
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            arr[curr]++;
        }
        for(int i =0; i<128; i++){
            int freq = arr[i];
            if(freq > 0){
if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add((char) i);
            }
            
        }
        for(int i=bucket.length-1; i>= 0; i--){
            List<Character> curr = bucket[i];
            if(curr != null){
                for(char val : curr){
                    for(int j=0; j<i; j++)
                    sb.append(val);
                }
             }
        }
        return sb.toString();
    }

}