package designPattern.test.memento;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Hero类
 */
public class Hero implements Originator {

    private String name;

    private Integer lifeValue;

    private Integer magicValue;

    private String weapon;

    public Hero() {
    }

    public Hero(String name, Integer lifeValue, Integer magicValue, String weapon) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.magicValue = magicValue;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(Integer lifeValue) {
        this.lifeValue = lifeValue;
    }

    public Integer getMagicValue() {
        return magicValue;
    }

    public void setMagicValue(Integer magicValue) {
        this.magicValue = magicValue;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


    public void eatTree() {
        try {
            for (int i = 0; i < 10; i++) {
                this.lifeValue = this.lifeValue + 5;
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drinkBlue() {
        try {
            for (int i = 0; i < 10; i++) {
                this.magicValue = this.magicValue + 5;
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void attacked(Integer damage) {
        this.lifeValue = this.lifeValue - damage;
    }

    public void useMagic(Integer value) {
        this.magicValue = this.magicValue - value;
    }

    /**
     * 保存快照
     */
    public void createMemento() {
        Memento memento = new Memento(getName(), getLifeValue(), getMagicValue(), getWeapon(), new Date());
        MementoHandler.add(memento);
    }

    /**
     * 撤销操作，撤销到上一次保存的状态
     */
    public void undo() {
        Memento memento = MementoHandler.get(this.getName());
        if (null != memento) {
            this.lifeValue = memento.getLifeValue();
            this.magicValue = memento.getMagicValue();
            this.weapon = memento.getWeapon();
        } else {
            System.out.println("当前已经是最初状态了，没法撤销!");
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                ", magicValue=" + magicValue +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
