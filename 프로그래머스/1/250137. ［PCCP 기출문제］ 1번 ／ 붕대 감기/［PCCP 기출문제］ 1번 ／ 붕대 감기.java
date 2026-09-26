class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0], x = bandage[1], y = bandage[2];
        int maxHealth = health;
        int cur = health;
        int streak = 0;
        int attackIdx = 0;
        int lastTime = attacks[attacks.length - 1][0];
        
        for (int time = 1; time <= lastTime; time++) {
            if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
                cur -= attacks[attackIdx][1];
                streak = 0;
                attackIdx++;
                if (cur <= 0) return -1;
            } else {
                streak++;
                cur = Math.min(cur + x, maxHealth);
                if (streak == t) {
                    cur = Math.min(cur + y, maxHealth);
                    streak = 0;
                }
            }
        }
        return cur;
    }
}