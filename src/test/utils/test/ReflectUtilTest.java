package utils.test;

import com.yanhuan.yhssm.domain.BaseBussinessDomain;
import com.yanhuan.yhssm.domain.BaseDomain;
import com.yanhuan.yhssm.utils.ReflectUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by yanhuan1 on 2018/1/23.
 */
public class ReflectUtilTest {

    @Test
    public void testReflect(){
        BaseDomain domain = new BaseDomain();
        domain.setId(1l);
        domain.setCreateTime(new Date());
        domain.setUpdateTime(new Date());
        domain.setCreateUser("yanhuan");
        domain.setUpdateUser("yanhuan");
        BaseBussinessDomain copy = (BaseBussinessDomain)ReflectUtil.copy(domain, BaseBussinessDomain.class);
        System.out.println(copy);

    }
}
