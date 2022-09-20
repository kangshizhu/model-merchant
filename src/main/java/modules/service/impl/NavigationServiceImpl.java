package modules.service.impl;

import modules.entity.Navigation;
import modules.mapper.NavigationMapper;
import modules.service.INavigationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
@Service
public class NavigationServiceImpl extends ServiceImpl<NavigationMapper, Navigation> implements INavigationService {

}
