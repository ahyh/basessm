package thread.test.callabletest;

/**
 * 脏读
 */
public class DirtyRead {

    private String username = "yanhuan";
    private String password = "1111111";

    /**
     * 设置值的方法和读取值的方法都需要加synchronized
     * @param username
     * @param password
     */
    public synchronized void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setValue的结果username:" + username + ",password:" + password);
    }

    public synchronized void getValue() {
        System.out.println("getValue的结果username:" + username + ",password:" + password);
    }

    public static void main(String[] args) {
        DirtyRead dirtyRead = new DirtyRead();
        Thread thread1 = new Thread(() -> dirtyRead.setValue("yudaijing", "2222222"));
        Thread thread2 = new Thread(() -> dirtyRead.getValue());
        thread1.start();
        thread2.start();
    }
}
