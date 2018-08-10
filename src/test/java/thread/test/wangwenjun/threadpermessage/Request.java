package thread.test.wangwenjun.threadpermessage;

/**
 * 请求
 */
public final class Request {

    /**
     * 请求中的信息
     */
    private final String message;

    public Request(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "Request{" +
                "message='" + message + '\'' +
                '}';
    }
}
