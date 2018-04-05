package designPattern.test.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * 大量的命令
 */
public class MacroCommand implements Command<Student> {

    private Stack<Command> commandStack = new Stack<>();

    @Override
    public void execute(Student student) {
        /**
         * 遍历commandStack中所有的命令执行
         */
        Iterator<Command> iterator = commandStack.iterator();
        while (iterator.hasNext()) {
            iterator.next().execute(student);
        }
    }

    /**
     * 添加一个命令
     *
     * @param command 命令
     */
    public void append(Command command) {
        commandStack.push(command);
    }

    /**
     * 撤销上一个命令
     */
    public void undo() {
        if (!commandStack.empty()) {
            commandStack.pop();
        }
    }

    /**
     * 清除所有的命令
     */
    public void clear() {
        commandStack.clear();
    }
}
