class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int char_map[] = new int[26];

        for(char c : tasks){
            char_map[c-'A']++;
        }
        Arrays.sort(char_map);
        int pre_slots = char_map[25]-1;
        int idleslots = pre_slots*n;
        for(int i = 24;i>=0;i--){
            idleslots-=Math.min(pre_slots, char_map[i]);
        }
        return idleslots>0?idleslots+len:len;
    }
}