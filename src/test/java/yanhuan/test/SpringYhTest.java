package yanhuan.test;

import com.yanhuan.yhssm.domain.BaseDomain;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringYhTest {

    @Test
    public void testGetBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-learn.xml");
        BaseDomain domain = applicationContext.getBean(BaseDomain.class);
        System.out.println(domain.getCreateUser());
    }
}
