package cn.yy.test;

import cn.yy.dao.TravelUserMapper;
import cn.yy.pojo.TravelUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
public class TravelUserMapperTest {

    @Autowired
    public TravelUserMapper travelUserMapper;
    @Test
    public void testInsert(){
        TravelUser user=new TravelUser();
        user.setAddress("陕西省西安市");
        user.setEmail("2106724409");
        user.setUserName("元元元元");
        user.setPassword("123456");
        user.setRole(1);
        user.setSex("男");
        user.setTravelUserExist(1);
        travelUserMapper.insert(user);
    }
}
