
import java.util.ArrayList;
public class Test_19_R_顺时针打印矩阵 {
    ArrayList  a=new ArrayList();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR=0;
        int tC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<=dR&&tC<=dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
        return a;
    }



    public  void printEdge(int [][] m,int tR,int tC,int dR,int dC){
        if(tR==dR){    //先判断是否只是一横行 如果是 打印该横行的列（通常用于内圈）
            for(int i=tC;i<=dC;i++){
                a.add(m[tR][i]);
            }
        }
        else if(tC==dC){  //再判断是否只是一竖列 如果是 打印该横行的列（通常用于内圈
            for(int i=tR;i<=dR;i++){
                a.add(m[i][tC]);
            }
        }
        else {
            int curC=tC;//用2个变量储存 用于判断当前位置
            int curR=tR;
            while(curC!=dC){      //当前位置未到达当前行的最右列 --》往右去
                a.add(m[tR][curC]);
                curC++;
            }
            while(curR!=dR){      //当前位置未到达当前列的最底行 --》往下去
                a.add(m[curR][dC]);
                curR++;
            }
            while(curC!=tC){      //当前位置未到达当前行的最左列 --》往左去
                a.add(m[dR][curC]);
                curC--;
            }
            while(curR!=tR){      //当前位置未到达当前列的最顶行 --》往上去
                a.add(m[curR][tC]);
                curR--;
            }
        }
    }
}
