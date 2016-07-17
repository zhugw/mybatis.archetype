package ${package}.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by duanmu on 7/3/16.
 */
@Data
public class DemoUserQuery{
    private Integer id;

    private String mobile;

    private String nick;

    private Date createTimeFrom;

    private Date createTimeTo;

    private int offset;

    private int itemsPerPage = 20;

}
