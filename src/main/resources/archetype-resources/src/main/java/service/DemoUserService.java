package ${package}.service;

import ${package}.dao.entity.DemoUserEntity;
import ${package}.dao.mapper.DemoUserMapper;
import ${package}.model.DemoUserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoUserService{
    @Autowired
    private DemoUserMapper userMapper;

    public DemoUserModel getUserById(int id) {
        DemoUserEntity entity = userMapper.findById(id);
        DemoUserModel model = new DemoUserModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }
}