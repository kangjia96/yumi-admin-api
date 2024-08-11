package cn.ikangjia.yumi.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午9:44
 */
@Data
@TableName("sys_user")
public class UserDO {
    private String id;
    private String username;
    private String password;

    private String nickname;
    private String email;
    private String phone;
    private Integer gender;
    private String avatar;
    private String remark;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
