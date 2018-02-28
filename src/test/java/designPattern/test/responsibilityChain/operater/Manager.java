package designPattern.test.responsibilityChain.operater;

import designPattern.test.responsibilityChain.Apply;

import java.util.Date;

/**
 * 处理者抽象类
 */
public abstract class Manager {

    private String name;

    //下一个处理者
    private Manager next;

    public Manager() {
    }

    public Manager(String name, Manager next) {
        this.name = name;
        this.next = next;
    }

    //抽象处理方法
    public abstract boolean handleApply(Apply apply);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getNext() {
        return next;
    }

    public void setNext(Manager next) {
        this.next = next;
    }

    /**
     * 统一的处理方式，实际项目中可能是修改了状态啥的，然后去更新数据库
     */
    public boolean operateApply(Apply apply){
        apply.setApplyStatus((byte) 1);
        apply.setOperateTime(new Date());
        System.out.println(apply);
        return true;
    }

}
