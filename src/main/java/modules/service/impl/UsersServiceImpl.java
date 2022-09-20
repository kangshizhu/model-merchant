package modules.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import modules.dto.UsersDto;
import modules.entity.Users;
import modules.mapper.UsersMapper;
import modules.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import modules.util.CommonConstant;
import modules.util.JwtUtil;
import modules.util.PasswordUtil;
import modules.util.RedisUtil;
import modules.util.shiro.LoginUser;
import modules.vo.Result;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Resource
    UsersMapper usersMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object login(UsersDto usersDto) {
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //密码加密
        String password = PasswordUtil.encrypt("cloud", usersDto.getPassword(),PasswordUtil.SALT);
        //查询用户是否存在
        queryWrapper.eq("phone",usersDto.getPhone()).eq("password",password).eq("type",0);
        Users userOne=usersMapper.selectOne(queryWrapper);
        //手机第一次登陆就创建一个新用户
        if(userOne==null){
            return Result.error("账号或密码错误");
        }
        // 生成token
        String token = JwtUtil.sign(userOne.getPhone(), userOne.getId());
        //redis存取用户信息和token
        Result<JSONObject> result=new Result<JSONObject>();
        Long date = new Date(System.currentTimeMillis() + JwtUtil.EXPIRE_DATE).getTime();
        //存入redis参数 loginUser
        LoginUser loginUser=new LoginUser();
        BeanUtils.copyProperties(userOne,loginUser);
        redisUtil.set(CommonConstant.PREFIX_USER_ADMIN_TOKEN + token, loginUser);
        redisUtil.expire(CommonConstant.PREFIX_USER_ADMIN_TOKEN + token, date);
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("userInfo", userOne);
        result.setResult(obj);
        return result;
    }
}
