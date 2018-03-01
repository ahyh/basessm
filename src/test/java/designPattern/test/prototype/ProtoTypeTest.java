package designPattern.test.prototype;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 原型模式测试
 */
public class ProtoTypeTest {

    @Test
    public void testPrototype() {
        Manager manager = new Manager();
        Bike bike1 = new Bike("小明");
        Bike bike2 = new Bike("小强");
        Bike bike3 = new Bike("小红");
        Car car1 = new Car("王总");
        Car car2 = new Car("李总");
        Car car3 = new Car("余总");
        manager.register(bike1.getOwner(), bike1);
        manager.register(bike2.getOwner(), bike1);
        manager.register(bike3.getOwner(), bike1);
        manager.register(car1.getOwner(), car1);
        manager.register(car2.getOwner(), car2);
        manager.register(car3.getOwner(), car3);
        Bike bike1Clone = (Bike) manager.create(bike1.getOwner());
        Parking parking = new Parking();
        String name = "保安";
        parking.setName(name);
        parking.setBikeList(Lists.newArrayList(bike1, bike2, bike3));
        parking.setCarList(Lists.newArrayList(car1, car2, car3));
        Map<String, Object> map = new HashMap();
        map.put("aa", "aa");
        map.put("bb", 2);
        map.put("cc", Lists.newArrayList(1.1, 2.2));
        parking.setMap(map);
        manager.register(parking.getName(), parking);
        System.out.println(bike1 == bike1Clone);
        Parking parkingClone = (Parking) manager.create("保安");
        System.out.println(parking == parkingClone);
        parking.getBikeList().add(bike1Clone);
        System.out.println(parkingClone.getBikeList().size());
        Parking parkingDeepClone = null;
        try {
            parkingDeepClone = (Parking) deepClone(parking);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parking == parkingDeepClone);
        parking.getBikeList().remove(bike2);
        parking.getBikeList().remove(bike1);
        System.out.println(parkingDeepClone.getBikeList().size());
    }

    /**
     * 深度克隆方法:通过对象流的方式实现的深度克隆
     */
    private Product deepClone(Product product) throws Exception {
        //将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(product);
        //从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (Product) oi.readObject();
    }
}
