/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package myTest;

import myTest.base.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yan Meng
 * @date 2018/5/31
 */
public class HelloTest {

    @Test
    public void testInit() throws Exception {
        String resouce = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resouce);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        SqlSession sqlSession = factory.openSession();
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("userId", "1");
            //sqlSession.selectList方法就是要详细分析的方法
            List<User> userss = sqlSession.selectList("myTest.base.userMapper.selectUserDetail", param);

            System.out.println(userss);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(sqlSession);
    }
}
