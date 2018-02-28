package designPattern.test.composite;

import org.junit.Test;

/**
 * 菜单测试
 */
public class MenuTest {

    @Test
    public void testMenu() {
        //定义根结点
        MenuEntry root = new MenuNode(1, "aaaa");
        //定义子结点
        MenuEntry subRoot1 = new MenuNode(2, "bbbb");
        MenuEntry subRoot2 = new MenuNode(3, "cccc");
        MenuEntry subRoot11 = new MenuNode(4, "dddd");
        MenuEntry subRoot21 = new MenuNode(5, "eeee");
        //定义叶子结点
        MenuEntry leaf111 = new MenuLeaf(6, "ffff");
        MenuEntry leaf112 = new MenuLeaf(7, "gggg");
        MenuEntry leaf211 = new MenuLeaf(8, "hhhh");
        MenuEntry leaf212 = new MenuLeaf(9, "iiii");
        //定义结点之间的组合关系
        root.add(subRoot1);
        root.add(subRoot2);
        subRoot1.add(subRoot11);
        subRoot2.add(subRoot21);
        subRoot11.add(leaf111);
        subRoot11.add(leaf112);
        subRoot21.add(leaf211);
        subRoot21.add(leaf212);
        //打印
        root.printMenu();
        subRoot1.printMenu();
        subRoot2.printMenu();
        subRoot11.printMenu();
        subRoot21.printMenu();
        leaf111.printMenu();
        leaf112.printMenu();
        leaf211.printMenu();
        leaf212.printMenu();
    }

}
