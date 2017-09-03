package com.zwx.smbms.serviceimpl;

import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserService userService;
    @Before
    public void setUp() throws Exception {
        userService=new UserServiceImpl();
    }

    @Test
    public void testadd() throws Exception {
        boolean result=false;
        User user=new User();
        user.setUserCode("hanyunxi");
        user.setUserName("韩云溪");
        user.setUserPassword("000000");
        result=userService.add(user);
        System.out.println(result);
        Assert.assertTrue("增加失败",result);
    }

}