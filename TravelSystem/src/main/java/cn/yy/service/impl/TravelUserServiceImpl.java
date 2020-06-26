package cn.yy.service.impl;

import cn.yy.dao.TravelUserMapper;
import cn.yy.pojo.TravelUser;
import cn.yy.pojo.TravelUserExample;
import cn.yy.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelUserServiceImpl implements TravelUserService {

    @Autowired
    private TravelUserMapper travelUserMapper;


    @Override
    public TravelUser selectById(Integer id) {
        /*
         * 这里似乎没有必要添加exist=1的条件.因为是数据回显,既然能在页面上显示出来,证明之前查询的时候exist就是1了.
         * */
        TravelUser travelUser=travelUserMapper.selectByPrimaryKey(id);
        return  travelUser;
    }

    @Override
    public TravelUser selectByUserNameAndPassword(String userName, String password) {
        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
//        String newPassword = MD5Utils.getMD5(password);
        criteria.andUserNameEqualTo(userName).andPasswordEqualTo(password);
        criteria.andTravelUserExistEqualTo(1);//确定用户没有被删除掉

        List<TravelUser> travelUsers = travelUserMapper.selectByExample(travelUserExample);
        if(!travelUsers.isEmpty()){
                return travelUsers.get(0);
        }

        return null;
    }

    @Override
    public TravelUser selectByUserName(String userName) {

        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);

        List<TravelUser> travelUsers = travelUserMapper.selectByExample(travelUserExample);
        if(!travelUsers.isEmpty()){
            return travelUsers.get(0);
        }
        return null;
    }

    @Override
    public void insertTravelUser(TravelUser travelUser) {

        travelUserMapper.insertSelective(travelUser);
    }

    @Override
    public List<TravelUser> selectAll() {
        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
        criteria.andTravelUserExistEqualTo(1);//只查询存在状态的用户

        List<TravelUser> travelUsers = travelUserMapper.selectByExample(travelUserExample);
        return travelUsers;
    }

    @Override
    public void updateTravelUser(TravelUser travelUser) {
        travelUserMapper.updateByPrimaryKeySelective(travelUser);
    }

    @Override
    public void deleteTravelUserById(Integer id) {
        TravelUser travelUser = travelUserMapper.selectByPrimaryKey(id);
        travelUser.setTravelUserExist(0);
        travelUserMapper.updateByPrimaryKeySelective(travelUser);
//        travelUserMapper.deleteByPrimaryKey(id);//以前的真删除，现在是假删除。
    }

    @Override
    public void deleteTravelUserBatch(List<Integer> idList) {

        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
        criteria.andTravelUserIdIn(idList);

        List<TravelUser> travelUsers = travelUserMapper.selectByExample(travelUserExample);
        for(TravelUser travelUser:travelUsers){
            travelUser.setTravelUserExist(0);
            travelUserMapper.updateByPrimaryKeySelective(travelUser);
        }

//        travelUserMapper.deleteByExample(travelUserExample);
    }

    /*通过邮箱查询用户*/
    @Override
    public TravelUser selectByEmail(String email) {
        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<TravelUser> travelUsers = travelUserMapper.selectByExample(travelUserExample);
        if(!travelUsers.isEmpty()){
            return travelUsers.get(0);
        }
        return null;

    }

    @Override
    public void updatePwdByEmail(String email,TravelUser travelUser) {
        TravelUserExample travelUserExample=new TravelUserExample();
        TravelUserExample.Criteria criteria = travelUserExample.createCriteria();
        criteria.andEmailEqualTo(email);
        travelUserMapper.updateByExampleSelective(travelUser,travelUserExample);
    }
}
