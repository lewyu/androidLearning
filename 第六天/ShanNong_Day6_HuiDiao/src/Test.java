
public class Test {
    
    public static void main(String[] args) {
        
        Mom m = new Mom();
        //��ǰ���Լ��
        m.date(new OnBuyPCListener() {
            
            @Override
            public void onBuyPC() {
                System.out.println("���ź��������ȥ��������");
            }
        });
        
        //����ִ�������Ĳ������ȴ��������
        m.time();
        
        
        
        
        
    }

}
