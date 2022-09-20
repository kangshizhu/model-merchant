package modules.service;

import modules.dto.UsersDto;
import modules.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
public interface IUsersService extends IService<Users> {

    Object login(UsersDto usersDto);
}
