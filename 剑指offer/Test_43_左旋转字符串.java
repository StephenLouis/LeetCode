/*


 */

public class Test_43_左旋转字符串 {
    // 左旋字符串
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        if (n >= s.length()) {
            n = n % (s.length());
        }
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();

    }
}
