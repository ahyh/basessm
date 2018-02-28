package designPattern.test.composite;

/**
 * 叶子结点
 */
public class MenuLeaf extends MenuEntry {

    public MenuLeaf(Integer code, String name) {
        super(code, name);
    }

    /**
     * 叶子结点打印菜单全路径
     */
    @Override
    public void printMenu() {
        StringBuffer sb = new StringBuffer(this.toString());
        while (this.parent != null) {
            sb.insert(0, this.parent);
            this.parent = this.parent.parent;
        }
        System.out.println(sb.toString());
    }

}
