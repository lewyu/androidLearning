
public class Test {
    
    public static void main(String[] args) {
        
        Mom m = new Mom();
        //提前达成约定
        m.date(new OnBuyPCListener() {
            
            @Override
            public void onBuyPC() {
                System.out.println("带着孩子买电脑去！！！！");
            }
        });
        
        //可以执行其他的操作，等待条件达成
        m.time();
        
        
        
        
        
    }

}
