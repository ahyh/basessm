package designPattern.test.composite;

/**
 * 菜单结点抽象类
 */
public abstract class MenuEntry {

    //父节点
    protected MenuEntry parent;

    //菜单编码
    private Integer code;

    //菜单名称
    private String name;

    public MenuEntry(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 添加子元素的方法
     */
    public MenuEntry add(MenuEntry entry) {
        return null;
    }

    /**
     * 如果是非叶子结点就打印打前结点所有子元素
     * 如果是叶子结点就打印完整路径
     */
    public abstract void printMenu();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuEntry getParent() {
        return parent;
    }

    public void setParent(MenuEntry parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MenuEntry{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
