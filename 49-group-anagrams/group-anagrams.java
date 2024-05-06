class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s: strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);

            if(!mp.containsKey(str))
            mp.put(str, new ArrayList<String>());
            mp.get(str).add(s);            
        }

        for(Map.Entry<String, List<String>> e : mp.entrySet()){
            result.add(e.getValue());
        }

        return result;
    }
}