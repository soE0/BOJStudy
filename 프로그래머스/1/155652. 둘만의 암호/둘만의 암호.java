class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipSet = new boolean[26];
        for (char c : skip.toCharArray()) {
            skipSet[c - 'a'] = true;
        }
        for (char c : s.toCharArray()) {
            int cur = c - 'a';
            int count = 0;
            while (count < index) {
                cur = (cur + 1) % 26;
                if (!skipSet[cur]) {
                    count++;
                }
            }
            answer.append((char) ('a' + cur));
        }
        return answer.toString();
    }
}