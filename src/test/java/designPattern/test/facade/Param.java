package designPattern.test.facade;

import java.io.Serializable;
import java.util.Map;

/**
 * 方法的入参
 */
public class Param implements Serializable {

    //方法的调用者
    private String invoker;

    //调用方法的令牌
    private String token;

    //将方法的入参封装在一个Map中
    private Map paramMap;

    public String getInvoker() {
        return invoker;
    }

    public void setInvoker(String invoker) {
        this.invoker = invoker;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map paramMap) {
        this.paramMap = paramMap;
    }
}
