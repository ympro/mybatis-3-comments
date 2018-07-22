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
package myTest.base;

import java.util.List;

/**
 * @author Yan Meng
 * @date 2018/5/31
 */
public class User {

    /**
     * 用户id，主键
     */
    private String id;

    private String username;

    /**
     * 用户号码
     */
    private String svcnum;

    private String password;

    /**
     * 一个用户只能对应一个客户
     */
    private Cust cust;

    /**
     * 一个用户可以有多个账户
     */
    private List<Acct> accts;

    /**
     * 用户类型，两种：普通用户和重要用户
     */
    private UserType type;

    public User() {
    }

    public User(String id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Cust getCust()
    {
        return cust;
    }

    public void setCust(Cust cust)
    {
        this.cust = cust;
    }

    public List<Acct> getAccts()
    {
        return accts;
    }

    public void setAccts(List<Acct> accts)
    {
        this.accts = accts;
    }

    public UserType getType()
    {
        return type;
    }

    public void setType(UserType type)
    {
        this.type = type;
    }

    public String getSvcnum()
    {
        return svcnum;
    }

    public void setSvcnum(String svcnum)
    {
        this.svcnum = svcnum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", svcnum='" + svcnum + '\'' +
                ", password='" + password + '\'' +
                ", cust=" + cust +
                ", accts=" + accts +
                ", type=" + type +
                '}';
    }
}
