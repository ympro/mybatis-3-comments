package myTest.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yan Meng
 * @date 2018/8/4.
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {
        //JDK动态代码要求实现InvocationHandler
        class AshanInvocationHandler implements InvocationHandler {

            private Object target;

            public AshanInvocationHandler(Object obj) {
                this.target = obj;
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk dynamic proxy before..");
                Object ret = method.invoke(this.target, args);
                System.out.println("jdk dynamic proxy after..");
                return ret;
            }
        }

        AshanService service = new AshanServiceImpl();
        AshanInvocationHandler handler = new AshanInvocationHandler(service);

        //利用proxy生成一个代理对象
        AshanService proxy = (AshanService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        proxy.service("jdk dynamic proxy");
    }

}
