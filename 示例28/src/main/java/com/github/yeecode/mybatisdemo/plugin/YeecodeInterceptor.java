package com.github.yeecode.mybatisdemo.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;


/**
 * 拦截器类上有注解 Intercepts，Intercepts的参数是 Signature 注解数组。每 Signature注解都声明了当前拦截器类要拦截的方法。
 * Signature注解中参数的含义如下。
 * · type:拦截器要拦截的类型。YeecodeInterceptor 拦截器要拦截的类型是ResultSetHandler类型。
 * · method:拦截器要拦截的 type类型中的方法。YeecodeInterceptor拦截器要拦截的是ResultSetHandler类型中的 handleResultSets 方法。
 * · args:拦截器要拦截的type类型中method方法的参数类型列表。在YeecodeInterceptor拦截器中，ResultSetHandler类型中的 handleResultSets方法只有一个 Statement类型的参数。
 * 当要拦截多个方法时，只需在 Intercepts数组中放入多个 Signature注解即可。
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class YeecodeInterceptor implements Interceptor {
    private String info;

    /**
     * intercept:拦截器类必须实现该方法。
     * @param invocation 拦截到的目标方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行原有方法
        Object result = invocation.proceed();
        // 打印原方法输出结果的数目
        System.out.println(info + ":" + ((List) result).size());
        // 返回原有结果
        return result;
    }

    /**
     * 拦截器类可以选择实现该方法。该方法用来为拦截器设置属性。
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        // 为拦截器设置属性
        info = properties.get("preInfo").toString();
    }
}
