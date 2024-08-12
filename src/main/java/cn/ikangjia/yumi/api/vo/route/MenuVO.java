package cn.ikangjia.yumi.api.vo.route;

import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 23:04
 */
@Data
public class MenuVO {
    private String name;
    private String path;
    private String component;
    private Meta meta;

    private Boolean visible;

    private List<MenuVO> children;
}
