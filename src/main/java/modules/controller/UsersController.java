package modules.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import modules.dto.UsersDto;
import modules.entity.Classroom;
import modules.entity.Users;
import modules.service.IUsersService;
import modules.util.PasswordUtil;
import modules.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  用户表
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    IUsersService iUsersService;

    @ApiOperation(value = "用户管理端后台登录", notes = "用户管理端后台登录用户type为0")
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody UsersDto usersDto) {
        return Result.OK(iUsersService.login(usersDto));
    }

    @ApiOperation(value = "用户管理端修改密码", notes = "用户管理端修改密码 密码加密")
    @PostMapping(value = "/updatePassword")
    @ResponseBody
    public Result updatePassword(@RequestBody  UsersDto usersDto) {
        Users users=new Users();
        BeanUtils.copyProperties(usersDto,users);
        String userpassword = PasswordUtil.encrypt("cloud", usersDto.getPassword(),PasswordUtil.SALT);
        users.setPassword(userpassword);
        iUsersService.updateById(users);
        return Result.OK("修改");
    }


}
