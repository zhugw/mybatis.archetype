package ${package}.dao.mapper;


import ${package}.dao.entity.DemoUserEntity;
import ${package}.model.DemoUserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoUserMapper {
    DemoUserEntity findById(int id);

    List<DemoUserEntity> findByIds(List<Integer> ids);

    List<DemoUserEntity> findUsers(DemoUserQuery query);

    int insertUser(DemoUserEntity entity);

    int updateMobile(@Param("id") int id, @Param("newMobile") String newMobile);
}