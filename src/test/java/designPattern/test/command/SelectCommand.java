package designPattern.test.command;

import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 查询命令
 */
public class SelectCommand implements Command<Student> {

    private final List<Student> list;

    public SelectCommand(List<Student> list) {
        this.list = list;
    }

    @Override
    public void execute(Student student) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(student.getId());
        //只能根据学号查询
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("List为空");
            return;
        }
        for (Student stu : list) {
            if (stu.getId().equals(student.getId())) {
                System.out.println("查询出student:" + stu);
                return;
            }
        }
        System.out.println("未查询到" + student.getId() + "对应的student");
    }
}
