class Solution {
    public int numSplits(String s) {
      int n = s.length();
      int[] left = new int[n];
      int[] right = new int[n];
    Set<Character> set = new HashSet<>();
    int unique=0;
    for (int i = 0; i < n; i++) {
        if (set.add(s.charAt(i))){
           unique++;
        } 
        left[i] = unique;
    }
    set.clear();
    unique = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (set.add(s.charAt(i))){
           unique++;
        } 
        right[i] = unique;
    }
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
        if (left[i] == right[i + 1]){
            count++;
        } 
    }
    return count;
}
}