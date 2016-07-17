package ${package}.dao.entity;

import lombok.Data;

import java.util.Date;
@Data
public class DemoUserEntity {
    private Integer id;

    private String mobile;

    private String nick;

    private Date createTime;

}