
public class Mom {

    //约定
    private OnBuyPCListener mListener;

    /**
     * 约定好事件
     */
    public void date(OnBuyPCListener listener) {
        mListener = listener;
        
    }

    public void time() {
        for (int i = 0; i < 7; i++) {
            
            //每次循环等待1s
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("儿子学了" + (i + 1) + "天");
        }
        
        //上面的时间已过，达成约定条件，触发回调，去买电脑
        mListener.onBuyPC();
    }

}
