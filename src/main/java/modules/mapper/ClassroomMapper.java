package modules.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import modules.entity.Classroom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2022-09-15
 */
public interface ClassroomMapper extends BaseMapper<Classroom> {

    Page<Classroom> selectPageVo(@Param("page")Page<Classroom> page, @Param("i")int i);
}
