package designPattern.test.command;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * 表示绘制一个点的命令
 */
public class InsertCommand implements Command<Student> {

    private final List<Student> list;

    public InsertCommand(List<Student> list) {
        this.list = list;
    }


    @Override
    public void execute(Student student) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(student.getId());
        Preconditions.checkNotNull(student.getName());
        Preconditions.checkNotNull(student.getGender());
        Preconditions.checkNotNull(student.getBirthday());
        System.out.println("模拟写入一条数据到student表中：" + student);
        list.add(student);
    }
}
