package com.yanhuan.yhssm.dynamo.scan;

import com.yanhuan.yhssm.dynamo.proxy.MapperProxyFactoryHolder;
import org.springframework.beans.factory.FactoryBean;

public class DyMapperFactoryBean<T> implements FactoryBean {

    private Class<T> mapperInterface;

    public DyMapperFactoryBean() {
        //intentionally empty
    }

    public DyMapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getObject() throws Exception {
        // 生成一个代理对象
        return MapperProxyFactoryHolder.getMapper(this.mapperInterface);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<T> getObjectType() {
        return this.mapperInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

}
