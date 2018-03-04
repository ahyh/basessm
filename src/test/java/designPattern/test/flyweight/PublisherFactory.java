package designPattern.test.flyweight;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * 出版社工厂：将出版社对象放在该类中持有的Map集合中
 */
public class PublisherFactory {

    //保存出版社ID和出版社对象键值对的集合
    private static Map<Long, Publisher> publisherMap = new HashMap<>();

    /**
     * 根据ID获取出版社对象，如果获取到就返回，否则新建一个Publisher对象返回
     * 并放在publisherMap中以便下次使用
     */
    public Publisher getPublisher(Long id) {
        Preconditions.checkNotNull(id);
        if (null != publisherMap.get(id)) {
            return publisherMap.get(id);
        }
        //如果集合中没有此信息的话，可能是从数据库中查询出来，或者通过其他方式获取到
        System.out.print("publisherMap没有此对象，模拟创建一个对象");
        Publisher publisher = new Publisher();
        publisher.setId(Long.valueOf(publisherMap.size() + 1));
        publisher.setPublisherName("第" + publisherMap.size() + 1 + "出版社");
        publisher.setContactName("第" + publisherMap.size() + 1 + "出版社联系人");
        publisher.setContactPhone(getRandomPhone());
        publisher.setAddress("北京"+publisherMap.size() + 1+"地址");
        publisher.setPostCode("100010");
        publisherMap.put(publisher.getId(),publisher);
        return publisher;
    }

    private String getRandomPhone() {
        StringBuffer sb = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            sb.append((int) (10 * Math.random()));
        }
        return sb.toString();
    }


}
