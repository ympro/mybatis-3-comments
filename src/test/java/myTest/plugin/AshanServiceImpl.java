package myTest.plugin;

/**
 * @author Yan Meng
 * @date 2018/8/4.
 */
public class AshanServiceImpl implements AshanService {
    @Override
    public void service(String name) {
        System.out.println("Hello "+name);
    }
}
