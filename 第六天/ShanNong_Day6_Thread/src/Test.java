
public class Test {

    public static void main(String[] args) {
        //4.实例化自定义线程类
        MyThread mt = new MyThread();
        //5.调用线程对象的start方法
        mt.start();

        //四.实例化Thread类，把自定义的Runnable类的对象作为参数传入构造器中
        Thread t = new Thread(new MyRunnable());
        //五.调用线程对象的start方法启动线程
        t.start();
        
        System.out.println("*****C:我是主线程*****");
        
        //法一：使用匿名内部类来实现
        new Thread() {
            public void run() {
                //增加子线程要执行的操作
                
            }
        }.start();
        
        //法二：使用匿名内部类来实现
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                //增加子线程要执行的操作
                
            }
        }).start();
        
    }

}
