package cn.yy.service.impl;

import cn.yy.dao.RealNameMapper;
import cn.yy.pojo.RealName;
import cn.yy.pojo.RealNameExample;
import cn.yy.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealNameServiceImpl implements RealNameService {

    @Autowired
    RealNameMapper realNameMapper;

    @Override
    public List<RealName> selectRealNameByTravelUserId(Integer travelUserId) {
        RealNameExample realNameExample=new RealNameExample();
        RealNameExample.Criteria criteria = realNameExample.createCriteria();
        criteria.andTravelUserId_FK_RealNameEqualTo(travelUserId);
        criteria.andRealNameExistEqualTo(1);//只查询存在状态的信息

        List<RealName> realNames = realNameMapper.selectByExample(realNameExample);
        return  realNames;
    }

    @Override
    public void insertRealName(RealName realName) {
        realNameMapper.insertSelective(realName);
    }

    @Override
    public RealName selectRealNameById(Integer realNameId) {
        /*
        * 这里似乎没有必要添加exist=1的条件.因为是数据回显,既然能在页面上显示出来,证明之前查询的时候exist就是1了.
        * */
        RealName realName = realNameMapper.selectByPrimaryKey(realNameId);
        return realName;
    }

    @Override
    public void updateRealName(RealName realName) {
        realNameMapper.updateByPrimaryKeySelective(realName);
    }

    @Override
    public void deleteRealNameById(Integer realNameId) {

        RealName realName = realNameMapper.selectByPrimaryKey(realNameId);
        realName.setRealNameExist(0);

        realNameMapper.updateByPrimaryKeySelective(realName);
//        realNameMapper.deleteByPrimaryKey(realNameId);
    }

    @Override
    public void deleteRealNameBatch(List<Integer> idList) {
        RealNameExample realNameExample=new RealNameExample();
        RealNameExample.Criteria criteria = realNameExample.createCriteria();
        criteria.andRealNameIdIn(idList);

        List<RealName> realNames = realNameMapper.selectByExample(realNameExample);
        for(RealName realName:realNames){
            realName.setRealNameExist(0);
            realNameMapper.updateByPrimaryKeySelective(realName);
        }

//        realNameMapper.deleteByExample(realNameExample);
    }

    @Override
    public String selectRealNameNameById(Integer realNameId) {

        RealName realName = realNameMapper.selectByPrimaryKey(realNameId);
        return realName.getRealName();
    }

}
