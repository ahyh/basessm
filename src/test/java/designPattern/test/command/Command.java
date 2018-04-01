package designPattern.test.command;

/**
 * 命令接口
 */
public interface Command<T> {


    /**
     * 命令执行方法
     */
    void execute(T t);
}
