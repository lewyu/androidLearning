
//һ.ʵ��Runnable�ӿ�
public class MyRunnable implements Runnable{

    //��.ʵ�ֽӿ��еĳ��󷽷�
    @Override
    public void run() {
        //��.��run�������������߳�Ҫִ�еĴ���
        for (int i = 0; i < 100; i++) {
            System.out.println("   B:" + i);
        }
    }

}
