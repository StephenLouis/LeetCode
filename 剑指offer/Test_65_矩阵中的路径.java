/*


 */

public class Test_65_矩阵中的路径 {
    // 一定要引入坐标系！！方便进行移动
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y


    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board,chars,i,j,0,used)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean backtrack(char[][] board,char[] word,int i,int j,int k,boolean[][] used){
        if (i < 0 || i >= board.length || j <0 || j >= board[0].length || board[i][j] != word[k] || used[i][j]){
            return false;
        }
        if (k == word.length - 1) return true;
        used[i][j] = true;
        boolean res = backtrack(board,word,i+1,j,k+1,used) || backtrack(board,word,i,j+1,k+1,used) ||
                backtrack(board,word,i-1,j,k+1,used) || backtrack(board,word,i,j-1,k+1,used);
        used[i][j] = false;
        return res;
    }
}
