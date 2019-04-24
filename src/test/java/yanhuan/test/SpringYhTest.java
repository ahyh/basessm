package yanhuan.test;

import com.yanhuan.yhssm.domain.BaseDomain;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringYhTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringYhTest.class);

    @Test
    public void testGetBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-learn.xml");
        BaseDomain domain = applicationContext.getBean(BaseDomain.class);
        System.out.println(domain.getCreateUser());
    }
}
