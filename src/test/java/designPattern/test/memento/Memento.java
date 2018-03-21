package designPattern.test.memento;

import java.util.Date;

/**
 * 备忘录模式
 */
public class Memento {

    //英雄名字
    private String name;

    //生命值
    private Integer lifeValue;

    //魔法值
    private Integer magicValue;

    //武器
    private String weapon;

    //保存时间
    private Date saveTime;

    public Memento() {
    }

    public Memento(String name, Integer lifeValue, Integer magicValue, String weapon, Date saveTime) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.magicValue = magicValue;
        this.weapon = weapon;
        this.saveTime = saveTime;
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

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "lifeValue=" + lifeValue +
                ", magicValue=" + magicValue +
                ", weapon='" + weapon + '\'' +
                ", saveTime=" + saveTime +
                '}';
    }
}
