package cn.ikangjia.yumi.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:12
 */
@Data
@TableName("sys_menu")
public class MenuDO {
    private String id;
    private String parentId;
    private String name;
    private String menuType;
    private Integer orderNum;
    private String routeName;
    private String routePath;
    private String component;

    private String icon;
    private String perm;
    private String params;
    private Boolean keepAlive;

    private Boolean visible;
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
