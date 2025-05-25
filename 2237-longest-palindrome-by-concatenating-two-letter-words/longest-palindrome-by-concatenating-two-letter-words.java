class Solution {
    public int longestPalindrome(String[] words) {
         Map<String, Integer> map = new HashMap<>();
        int len = 0;
        boolean center = false;

        for (String w : words) {
            String rev = new StringBuilder(w).reverse().toString();
            if (map.getOrDefault(rev, 0) > 0) {
                len += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                len += 2;
                break;
            }
        }

        return len;
    }
}