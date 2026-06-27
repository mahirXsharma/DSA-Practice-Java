class Solution {
    public String frequencySort(String s) {
        List<Character> bucket[] = new ArrayList[s.length() + 1];
        int arr[] = new int[128];
        // store every char
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            arr[curr]++;
        }
        // put in the bucket
        for (int i = 0; i < 128; i++) {
            int freq = arr[i];
            if (freq > 0) {
                if (bucket[freq] == null)
                    bucket[freq] = new ArrayList<>();
                bucket[freq].add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder("");
        // looping backwards in the bucket
        for (int i = bucket.length - 1; i > 0; i--) {
            List<Character> curr = bucket[i];
            if (curr != null) {
                for (char ch : curr) {
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }

        }
        return sb.toString();
    }
}