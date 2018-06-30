
//1.继承Thread类
public class MyThread extends Thread {

    // 2.重写 Thread类中的run方法
    @Override
    public void run() {
        // 3.在run方法中增加子线程要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println("A:" + i);
        }
    }

}
