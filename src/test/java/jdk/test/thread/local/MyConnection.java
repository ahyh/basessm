package jdk.test.thread.local;

/**
 * 连接
 */
public class MyConnection {

    private String name;

    public MyConnection() {
    }

    public MyConnection(String name) {
        this.name = name;
    }

    /**
     * 模拟执行SQL
     */
    public void executeSQL(String sql) {
        System.out.println("Connection:【" + name + "】，executeSQL:【" + sql + "】");
    }

    @Override
    public String toString() {
        return "MyConnection{" +
                "name='" + name + '\'' +
                '}';
    }
}
