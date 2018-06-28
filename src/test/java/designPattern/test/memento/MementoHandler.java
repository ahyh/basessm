package designPattern.test.memento;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保存对象的状态
 */
public class MementoHandler {

    //最大保存的Memento数量，即最多可撤销次数
    private static final int CAPACITY = 10;

    //保存Memento的集合
    private static Map<String, List<Memento>> momentoMap = new HashMap<>();

    /**
     * 保存对象状态
     */
    public static void add(Memento memento) {
        if (momentoMap.containsKey(memento.getName())) {
            List<Memento> mementoList = momentoMap.get(memento.getName());
            if (mementoList.size() < CAPACITY) {
                momentoMap.get(memento.getName()).add(memento);
            } else {
                List<Memento> tempList = mementoList.subList(1, CAPACITY);
                tempList.add(memento);
                momentoMap.put(memento.getName(), tempList);
            }
        } else {
            momentoMap.put(memento.getName(), Lists.newArrayList(memento));
        }
    }

    /**
     * 返回name对应的hero的前num次状态
     */
    public static Memento get(String name) {
        if (momentoMap.containsKey(name)) {
            List<Memento> mementoList = momentoMap.get(name);
            if (CollectionUtils.isNotEmpty(mementoList)) {
                //删除最后一个元素并返回
                return mementoList.remove(mementoList.size() - 1);
            }
        }
        return null;
    }

}
