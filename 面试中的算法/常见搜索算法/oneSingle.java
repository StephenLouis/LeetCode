package 常见搜索算法;

/*
    1.饿汉模式：
        1.声明，创建
 */
public class oneSingle {
    private oneSingle one;
    public oneSingle get;
    private oneSingle get(){
        oneSingle one = new oneSingle();
        return one;
    }
}
