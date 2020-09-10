package 回溯法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class No17_电话号码的字母组合 {
    List<String> res = new ArrayList<String>();
    HashMap<Character,String> hashMap = new HashMap<>();
    StringBuilder tmp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");

        backtrack(digits,0,tmp);
        return res;
    }

    //index
    public void backtrack(String digits,int input_index,StringBuilder tmp){
        if (tmp.length() == digits.length()){
            res.add(tmp.toString());
            return;
        }

        //为了获取当前字符串
        String currenString = hashMap.get(digits.charAt(input_index));
        int length = currenString.length();

        for (int i = 0; i < length; i++) {
            //做选择
            tmp.append(currenString.charAt(i));
            //递归
            backtrack(digits,input_index+1,tmp);
            //回溯
            tmp = tmp.deleteCharAt(tmp.length() - 1);
        }

    }

    public static void main(String[] args) {
        String a = "23";
        No17_电话号码的字母组合 solution = new No17_电话号码的字母组合();
        System.out.println(solution.letterCombinations(a));
    }

}