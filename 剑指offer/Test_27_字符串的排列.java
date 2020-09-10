/*


 */

import java.util.ArrayList;
import java.util.Arrays;

public class Test_27_字符串的排列 {
    ArrayList<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        int[] used = new int[s.length()];
        //如果要处理 string 中的字符串，将其转成 charArray 最好。也是一种常用做法
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        backtrack(charArray,used);
        return res.toArray(new String[0]);
    }

    StringBuilder path = new StringBuilder();

    public void backtrack(char[] charsArray,int[] used){
        //递归结束条件
        if (path.length() == charsArray.length){
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < charsArray.length; i++) {
            if (used[i] != 0){
                continue;
            }
            //剪枝
            if (i > 0  && charsArray[i] == charsArray[i-1]&& used[i - 1] == 0){
                continue;
            }

            path.append(charsArray[i]);
            used[i] = 1;
            backtrack(charsArray,used);
            path.deleteCharAt(path.length() - 1);
            used[i] = 0;

        }

    }
}
