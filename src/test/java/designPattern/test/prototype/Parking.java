package designPattern.test.prototype;

import java.util.List;
import java.util.Map;

/**
 * 停车场类
 */
public class Parking implements Product {

    private String name;

    private List<Bike> bikeList;

    private List<Car> carList;

    private Map<String, Object> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public void use(String s) {
        System.out.println("-----Parking-----" + s);
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
