class Solution {
    public int partitionString(String s) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                count++;
                set.clear();
                set.add(ch);
            }
            else if(!set.contains(ch)){
                set.add(ch);
            }
        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
    }
}