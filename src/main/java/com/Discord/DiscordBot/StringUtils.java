package com.Discord.DiscordBot;

public class StringUtils {
    // Compute Levenshtein distance between two strings
    public static int levenshtein(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + cost
                    );
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    // Check if two strings are "close enough"
    public static boolean isCloseMatch(String input, String answer) {
        input = input.toLowerCase().trim();
        answer = answer.toLowerCase().trim();

        int distance = levenshtein(input, answer);
        int maxLen = Math.max(input.length(), answer.length());

        // Accept if similarity is >= ~80%
        double similarity = 1.0 - ((double) distance / maxLen);
        return similarity >= 0.8;
    }
}
