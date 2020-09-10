/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

 */

public class Test_02_替换空格 {
    public String replaceSpace(StringBuffer str) {
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                number++;
            }
        }

        int old_length = str.length();
        int new_length = str.length() + number * 2;
        str.setLength(new_length);

        for (int i = old_length - 1; i >= 0; i--) {
            if(str.charAt(i) != ' '){
                str.setCharAt(new_length - 1,str.charAt(i));
                new_length --;
            }else {
                str.setCharAt(new_length - 1,'0');
                str.setCharAt(new_length - 2,'2');
                str.setCharAt(new_length - 3,'%');
                new_length -= 3;
            }

        }
        return str.toString();
    }
}
