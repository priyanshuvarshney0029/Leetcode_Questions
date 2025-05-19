class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

         StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            while (freq-- > 0) {
                sb.append(ch);
            }
        }
       return  sb.toString();
    }
}