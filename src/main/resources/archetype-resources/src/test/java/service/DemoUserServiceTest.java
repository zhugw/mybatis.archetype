package ${package}.service;

import ${package}.dao.entity.DemoUserEntity;
import ${package}.dao.mapper.DemoUserMapper;
import ${package}.model.DemoUserModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by duanmu on 7/10/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoUserServiceTest {
    @InjectMocks
    private DemoUserService service;
    @Mock
    private DemoUserMapper userMapper;
    @Test
    public void test_getUserById_successfully() throws Exception {
        int id = 1;
        DemoUserEntity entity = new DemoUserEntity();
        entity.setId(id);
        entity.setMobile(RandomStringUtils.randomNumeric(11));
        entity.setNick(RandomStringUtils.randomAlphabetic(10));
        Mockito.when(userMapper.findById(id)).thenReturn(entity);
        DemoUserModel model = service.getUserById(id);
        Assert.assertEquals(entity.getId(), model.getId());
        Assert.assertEquals(entity.getMobile(), model.getMobile());
        Assert.assertEquals(entity.getNick(), model.getNick());
    }

}