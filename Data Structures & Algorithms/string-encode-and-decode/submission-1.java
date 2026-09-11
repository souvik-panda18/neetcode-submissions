class Solution {

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Extract length
            StringBuilder lenStr = new StringBuilder();
            while (str.charAt(i) != '#') {
                lenStr.append(str.charAt(i));
                i++;
            }
            int len = Integer.parseInt(lenStr.toString());
            i++; // skip the '#'
            
            // Extract the actual word
            String word = str.substring(i, i + len);
            ans.add(word);
            i += len; // move pointer forward
        }

        return ans;
    }


}
