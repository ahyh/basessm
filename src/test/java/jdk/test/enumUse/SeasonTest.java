package jdk.test.enumUse;

import org.junit.Test;

/**
 * 枚举使用
 */
public class SeasonTest {

    /**
     * enum特性1：创建enum时，编译器自动添加toString方法
     * 且toString方法的返回值就是enum实例的名字
     */
    @Test
    public void testSeasonStr() {
        Season season = Season.SPRING;
        System.out.println(season);
    }

    /**
     * enum特性2：创建enum时，编译器自动添加ordinal方法
     * 且ordinal方法的返回值就是enum实例的声明的顺序
     */
    @Test
    public void testSeasonOrdinal() {
        for (Season season : Season.values()) {
            System.out.println(season + "==ordinal:" + season.ordinal());
        }
    }

    /**
     * 测试枚举在switch语句中的使用方法
     */
    @Test
    public void testSeasonSwitch(){
        Season season = Season.SPRING;
        System.out.println(doSomething(season));
    }

    /**
     * enum特性3：可以在switch语句中使用枚举，使代码的可读性更强
     */
    private String doSomething(Season season){
        if(season != null){
            switch (season){
                case SPRING:
                    return "春游去";
                case SUMMER:
                    return "划船去";
                case AUTOMN:
                    return "秋游去";
                case WINTER:
                    return "滑雪去";
            }
        }
        return null;
    }


}
