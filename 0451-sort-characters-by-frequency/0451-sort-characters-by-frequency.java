class Solution {
    class Info{
        char ch;
        int freq;
        public Info(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b)->b.freq - a.freq);
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char key : map.keySet()){
            pq.add(new Info(key, map.get(key)));
        }
        while(!pq.isEmpty()){
            Info curr = pq.remove();
            for(int i=0; i<curr.freq; i++) sb.append(curr.ch);
        }
        return sb.toString();
    }

}