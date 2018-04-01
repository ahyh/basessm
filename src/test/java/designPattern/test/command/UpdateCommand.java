package designPattern.test.command;

import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 修改命令：只能修改一条，根据id修改
 */
public class UpdateCommand implements Command<Student> {

    private final List<Student> list;

    public UpdateCommand(List<Student> list) {
        this.list = list;
    }

    @Override
    public void execute(Student student) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(student.getId());
        System.out.println("模拟修改student" + student);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("list为空");
            return;
        }
        System.out.println("模拟修改操作" + student);
        for (Student stu : list) {
            if (stu.getId().equals(student.getId())) {
                stu.setName(student.getName());
                stu.setGender(student.getGender());
                stu.setBirthday(student.getBirthday());
                break;
            }
        }
    }
}
