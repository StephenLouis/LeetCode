/*


 */

import java.util.HashMap;

public class Test_34_第一个只出现一次的字符位置 {
    public char firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> dic = new HashMap<>();
        for (char chars:charArray){
            if (!dic.containsKey(chars)){
                dic.put(chars,1);
            }else {
                dic.put(chars,dic.get(chars)+1);
            }
        }

        for (char chars:charArray){
            if (dic.get(chars) == 1){
                return chars;
            }
        }
        return ' ';

    }
}
