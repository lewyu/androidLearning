
public class Test {

    public static void main(String[] args) {
        //4.ʵ�����Զ����߳���
        MyThread mt = new MyThread();
        //5.�����̶߳����start����
        mt.start();

        //��.ʵ����Thread�࣬���Զ����Runnable��Ķ�����Ϊ�������빹������
        Thread t = new Thread(new MyRunnable());
        //��.�����̶߳����start���������߳�
        t.start();
        
        System.out.println("*****C:�������߳�*****");
        
        //��һ��ʹ�������ڲ�����ʵ��
        new Thread() {
            public void run() {
                //�������߳�Ҫִ�еĲ���
                
            }
        }.start();
        
        //������ʹ�������ڲ�����ʵ��
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                //�������߳�Ҫִ�еĲ���
                
            }
        }).start();
        
    }

}
