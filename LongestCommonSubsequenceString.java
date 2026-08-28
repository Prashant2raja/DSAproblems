package Java.DP;

public class LongestCommonSubsequenceString {

    public static int lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n;
        int j = m;

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i -1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("The ans Stirng is " + sb.reverse().toString());

        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = "defgk";
        String text2 = "abegk";

        int l = lcs(text1, text2);

        System.out.println("The length is " + l);
    }
}
