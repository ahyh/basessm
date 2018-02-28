package designPattern.test.composite;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单中的结点
 */
public class MenuNode extends MenuEntry {

    /**
     * 非叶子结点的所有子元素
     */
    private List<MenuEntry> subMenuList = new ArrayList();

    public MenuNode(Integer code, String name) {
        super(code, name);
    }

    /**
     * 添加子元素方法
     */
    @Override
    public MenuEntry add(MenuEntry entry) {
        subMenuList.add(entry);
        entry.setParent(this);
        return this;
    }

    /**
     * 非叶子结点打印所有子元素
     */
    @Override
    public void printMenu() {
        StringBuffer sb = new StringBuffer();
        if (CollectionUtils.isNotEmpty(subMenuList)) {
            for (MenuEntry entry : subMenuList) {
                sb.append(entry.toString());
            }
        }
        System.out.println(sb);
    }

}
