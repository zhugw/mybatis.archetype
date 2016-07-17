package ${package}.dao.mapper;

import com.google.common.collect.Lists;
import ${package}.common.AbstractTest;
import ${package}.dao.entity.DemoUserEntity;
import ${package}.model.DemoUserQuery;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class DemoUserMapperTest extends AbstractTest {

    @Autowired
    private DemoUserMapper mapper;

    @Test
    public void test_add_get_update_user() {
        DemoUserEntity entity = generateDemoUseEntity();
        mapper.insertUser(entity);
        Assert.assertNotNull(entity.getId());

        DemoUserEntity entity1 = mapper.findById(entity.getId());
        Assert.assertEquals(entity.getMobile(), entity1.getMobile());
        Assert.assertEquals(entity.getNick(), entity1.getNick());

        String newMobile = RandomStringUtils.randomNumeric(11);
        mapper.updateMobile(entity.getId(), newMobile);

        DemoUserEntity entity2 = mapper.findById(entity.getId());
        Assert.assertEquals(newMobile, entity2.getMobile());

        List<DemoUserEntity> list = mapper.findByIds(Lists.newArrayList(entity.getId()));
        Assert.assertEquals(1, list.size());

    }

    @Test
    public void test_findUsers_by_createTime() throws Exception {
        //首先创建一个用户
        DemoUserEntity entity = generateDemoUseEntity();
        mapper.insertUser(entity);
        // 校验起始日期
        DemoUserQuery query = new DemoUserQuery();
        query.setMobile(entity.getMobile());
        Date today = DateTime.now().withTimeAtStartOfDay().toDate();
        query.setCreateTimeFrom(today); //创建时间起始日期是今天
        List<DemoUserEntity> list = mapper.findUsers(query);
        Assert.assertEquals(1, list.size());

        Date tomorrow = DateTime.now().withTimeAtStartOfDay().plusDays(1).toDate(); //查询起始日期是明天
        query.setCreateTimeFrom(tomorrow);
        list = mapper.findUsers(query);
        Assert.assertEquals(0, list.size());

        //校验结束日期
        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(today);
        list = mapper.findUsers(query);
        Assert.assertEquals(0, list.size());


        query.setCreateTimeTo(tomorrow);
        list = mapper.findUsers(query);
        Assert.assertEquals(1, list.size());
    }
    @Test
    public void test_findUsers_by_nick() throws Exception {
        //首先创建一个用户
        DemoUserEntity entity = generateDemoUseEntity();
        mapper.insertUser(entity);

        DemoUserQuery query = new DemoUserQuery();
        query.setNick(entity.getNick());
        List<DemoUserEntity> list = mapper.findUsers(query);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(entity.getNick(), list.get(0).getNick());
    }

    private DemoUserEntity generateDemoUseEntity() {
        DemoUserEntity entity = new DemoUserEntity();
        String mobile = RandomStringUtils.randomNumeric(11);
        entity.setMobile(mobile);
        String nick = RandomStringUtils.randomAlphabetic(10);
        entity.setNick(nick);

        return entity;
    }
}