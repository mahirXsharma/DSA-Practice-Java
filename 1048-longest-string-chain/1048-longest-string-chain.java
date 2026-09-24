class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length()-b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 1;
        for(String word : words){
            // for ever word, chop its characters one by one
            int currMax = 1;
            for(int i=0; i<word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String pred = sb.toString();

                if(dp.containsKey(pred)){
                    currMax = Math.max(currMax, dp.get(pred) + 1);
                }
            }

            dp.put(word, currMax);
            maxLength = Math.max(maxLength, currMax);
        }

        return maxLength;
    }
}