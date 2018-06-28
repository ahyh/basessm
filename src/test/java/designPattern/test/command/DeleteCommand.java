package designPattern.test.command;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * 删除命令
 */
public class DeleteCommand implements Command<Student> {

    private final List<Student> list;

    public DeleteCommand(List<Student> list) {
        this.list = list;
    }

    @Override
    public void execute(Student student) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(student.getId());
        System.out.println("模拟删除student" + student);
        for (Student stu : list) {
            if (stu.getId().equals(student.getId())) {
                list.remove(stu);
                return;
            }
        }
    }
}
