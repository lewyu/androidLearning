
public class Mom {

    //Լ��
    private OnBuyPCListener mListener;

    /**
     * Լ�����¼�
     */
    public void date(OnBuyPCListener listener) {
        mListener = listener;
        
    }

    public void time() {
        for (int i = 0; i < 7; i++) {
            
            //ÿ��ѭ���ȴ�1s
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("����ѧ��" + (i + 1) + "��");
        }
        
        //�����ʱ���ѹ������Լ�������������ص���ȥ�����
        mListener.onBuyPC();
    }

}
