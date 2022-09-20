package modules.service.impl;

import modules.entity.Classroom;
import modules.mapper.ClassroomMapper;
import modules.service.IClassroomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-15
 */
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {

}
