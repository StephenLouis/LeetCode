import java.util.ArrayList;

/**
 * @author lupengchn@qq.com
 * @date 2020/9/2 11:40
 */
public class Main {
    public ArrayList<ArrayList<String>> get(ArrayList<String> product, String key) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        for (int i = 0; i < key.length(); i++) {
            ArrayList<String> tmp = new ArrayList<>();
            String word = key.substring(i);
            for (int j = 0; j < product.size(); j++) {
                if (word.equals(product.get(j).substring(i))) {
                    tmp.add(product.get(j));
                }
            }
            res.add(new ArrayList<>(tmp));
        }

        return res;

    }

    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<String> pro = new ArrayList<>();
        pro.add("abc");
        pro.add("abd");
        pro.add("asss");
        pro.add("abcd");
        String key = "abcd";
        ArrayList<ArrayList<String>> res = main.get(pro, key);
        System.out.println(res);
    }

}
