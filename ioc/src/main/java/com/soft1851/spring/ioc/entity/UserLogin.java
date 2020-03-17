package com.soft1851.spring.ioc.entity;

/**
 * @author Zeng
 * @ClassName UserLogin
 * @Description TOOD
 * @Date 2020/3/12
 * @Version 1.0
 **/
public class UserLogin {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean userLogin(User user) {
        return "admin".equals(user.getAccount()) & "111".equals(user.getPassword());
    }
}
