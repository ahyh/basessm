package designPattern.test.command;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 命令模式测试
 */
public class CommandTest {

    @Test
    public void testCommand() {
        List<Student> studentList = new ArrayList<>();
        new InsertCommand(studentList).execute(new Student(1001l, "aaa", (byte) 1, new Date()));
        new InsertCommand(studentList).execute(new Student(1002l, "bbb", (byte) 0, new Date()));
        new InsertCommand(studentList).execute(new Student(1003l, "ccc", (byte) 1, new Date()));
        new InsertCommand(studentList).execute(new Student(1004l, "ddd", (byte) 0, new Date()));
        new DeleteCommand(studentList).execute(new Student(1001l, null, null, null));
        new UpdateCommand(studentList).execute(new Student(1002l, "eee", (byte) 0, new Date()));
        new SelectCommand(studentList).execute(new Student(1003l, null, null, null));
        System.out.println();
    }

}
