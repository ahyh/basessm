package designPattern.test.memento;

import org.junit.Test;

/**
 * 备忘录模式测试
 */
public class MementoTest {

    @Test
    public void testMemento(){
        Hero cm = new Hero("cm",500,500,"权杖");
        cm.attacked(200);
        cm.eatTree();
        cm.createMemento();
        System.out.println(cm);

        cm.drinkBlue();
        cm.changeWeapon("大剑");
        cm.createMemento();
        System.out.println(cm);

        cm.attacked(300);
        cm.useMagic(200);
        cm.changeWeapon("金箍棒");
        System.out.println(cm);
        //进行两次撤销操作
        cm.undo();
        cm.undo();
        System.out.println(cm);
    }
}
