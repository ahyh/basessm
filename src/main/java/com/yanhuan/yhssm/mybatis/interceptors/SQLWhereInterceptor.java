package com.yanhuan.yhssm.mybatis.interceptors;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * MyBatis拦截器
 *
 * @author yanhuan1
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class SQLWhereInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(SQLWhereInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object params = args[1];
        MappedStatement statement = (MappedStatement) args[0];
        RawSqlSource sqlSource = (RawSqlSource) statement.getSqlSource();
        BoundSql boundSql = sqlSource.getBoundSql(args[0]);
        String sql = boundSql.getSql();
        // 获得出参
        Object returnValue = invocation.proceed();
        logger.error("args:" + JSON.toJSONString(args));
        return returnValue;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
