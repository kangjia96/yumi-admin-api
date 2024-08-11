package cn.ikangjia.yumi.api.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午11:26
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @GetMapping
    public String getRoleList() {
        return "role list";
    }

    @GetMapping("/{id}")
    public String getRole(@PathVariable("id") String id) {
        return "role " + id;
    }

    @PostMapping
    public String addRole(@RequestBody String role) {
        return "add role " + role;
    }

    @PutMapping
    public String updateRole(@RequestBody String role) {
        return "update role " + role;
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable("id") String id) {
        return "delete role " + id;
    }

    @DeleteMapping
    public String deleteRoleList(@RequestBody String roleList) {
        return "delete role list " + roleList;
    }
}
