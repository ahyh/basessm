package yanhuan.test;

import com.yanhuan.yhssm.utils.EncrypUtil;
import org.junit.Test;

public class EncryUtilTest {

    @Test
    public void testEncode(){
        String str = "yanhuan";
        String s = EncrypUtil.encodeJDKBase64(str);
        String s1 = EncrypUtil.decodeJDKBase64(s);
    }

    @Test
    public void testDecode(){
        String str = "amQuY29t";
        String s = EncrypUtil.decodeJDKBase64(str);
        System.out.println(s);
    }
}
