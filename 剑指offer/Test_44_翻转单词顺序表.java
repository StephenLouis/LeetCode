/*


 */


public class Test_44_翻转单词顺序表 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] keyWords = s.split(" ");
        for (int i = keyWords.length - 1; i >= 0; i--) {
            // 字符串判断用equal，空字符串用""
            if (!keyWords[i].equals("")) {
                res.append(keyWords[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

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
