package lambdasinaction.chap2;

public class Practice_2_2 {
    public static void main(String ... args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }

    public static class MeaningOfThis
    {
        public final int value = 4;  // 外部类变量
        public void doIt()
        {
            int value = 6;  // 局部变量
            Runnable r = new Runnable(){
                public final int value = 5;  // 匿名类变量
                public void run(){
                    int value = 10;  // 局部变量
                    System.out.println(this.value);  // this 关键字指向当前实例化的对象，即 Runnable 实例对象，因此访问的是匿名类变量 5

                    // 补充示例
                    System.out.println("匿名内部类的value (this.value): " + this.value);  // 输出 5
                    System.out.println("外部类的value (MeaningOfThis.this.value): " + MeaningOfThis.this.value);  // 输出 4
                    System.out.println("局部变量value: " + value);  // 输出 10
                }
            };
            r.run();
        }
    }
}
