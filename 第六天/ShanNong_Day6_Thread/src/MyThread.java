
//1.�̳�Thread��
public class MyThread extends Thread {

    // 2.��д Thread���е�run����
    @Override
    public void run() {
        // 3.��run�������������߳�Ҫִ�еĴ���
        for (int i = 0; i < 100; i++) {
            System.out.println("A:" + i);
        }
    }

}
