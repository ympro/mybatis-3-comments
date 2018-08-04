package myTest.plugin;

import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author Yan Meng
 * @date 2018/8/4.
 */
//这个注解会被Plugin读取
@Intercepts
        (
                {
                        @Signature//定义方法签名
                                (
                                        type = AshanService.class,
                                        method = "service",
                                        args = {String.class}
                                )
                }
        )

public class PluginTest implements Interceptor {

    private String name = "";

    public PluginTest(String name) {
        super();
        this.name = name;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("AshanInterceptor[" + name + "]...before...");
        Object obj = invocation.proceed();
        System.out.println("AshanInterceptor[" + name + "]...after...");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        if (target != null && target instanceof AshanService) {
            //Plugin是mybatis提供的
            return Plugin.wrap(target, this);
        }
        return target;

    }

    @Override
    public void setProperties(Properties properties) {

    }

    public static void main(String[] args) {
        AshanService service = new AshanServiceImpl();
        PluginTest aiNoName = new PluginTest("no_name");
        //直接用Interceptor.plugin生成一个代理
        AshanService proxy1 = (AshanService) aiNoName.plugin(service);
        proxy1.service("ashan");


        System.out.println("######################");

        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor(new PluginTest("1"));
        chain.addInterceptor(new PluginTest("2"));
        chain.addInterceptor(new PluginTest("3"));
        //用InterceptorChain生成一个代理
        AshanService proxy2 = (AshanService) chain.pluginAll(service);
        proxy2.service("chain");
    }

}
