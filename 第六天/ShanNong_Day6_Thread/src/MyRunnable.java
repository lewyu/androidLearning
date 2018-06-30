
//一.实现Runnable接口
public class MyRunnable implements Runnable{

    //二.实现接口中的抽象方法
    @Override
    public void run() {
        //三.在run方法中增加子线程要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println("   B:" + i);
        }
    }

}
