package 面试中的算法;

public class N_02_最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String prefix = strs[0];

        for(String str:strs){
            while (str.indexOf(prefix) != 0){
                if (prefix.length() == 1) return "";
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        String[] strs = {"customer","car","cat"};
        System.out.println(longestCommonPrefix(strs));
    }
}
