package modules.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import modules.dto.ClassroomDto;
import modules.entity.Classroom;
import modules.mapper.ClassroomMapper;
import modules.vo.Result;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-15
 */
@Api(tags = "模板接口")
@Log4j2
@RestController
@RequestMapping("/classroom")

public class ClassroomController {

    @Resource
    ClassroomMapper classroomMapper;

    @ApiOperation(value = "模板接口获取用户", notes = "查询用户信息")
    @PostMapping(value = "/queryUser")
    @ResponseBody
    public Result queryRuleUser(@RequestBody @Valid ClassroomDto classroomDto) {
        Classroom classroom=new Classroom();
        classroomMapper.insert(classroom);
        Page<Classroom> page=new Page<>(1,10);
        QueryWrapper<Classroom> QueryWrapper=new QueryWrapper<>();
        IPage<Classroom> classroomList=classroomMapper.selectPage(page,QueryWrapper);
        return Result.OK(classroomList);
    }

    @ApiOperation(value = "模板接口获取用户", notes = "查询用户信息")
    @PostMapping(value = "/select")
    @ResponseBody
    public Result select() {
        Classroom classroom=new Classroom();
        classroom.setUsernames("111");
        classroomMapper.insert(classroom);
        Page<Classroom> page=new Page<>(1,5);
        Page<Classroom> classroomList=classroomMapper.selectPageVo(page,1);
        return Result.OK(classroomList);
    }

    @ApiOperation(value = "模板接口修改用户", notes = "修改用户信息")
    @PostMapping(value = "/update")
    @ResponseBody
    public Result update() {
        Classroom classroom=new Classroom();
        classroom.setId(1);
        classroomMapper.updateById(classroom);
        return Result.OK("修改");
    }


    @ApiOperation(value = "模板接口获取用户", notes = "模板接口根据id查询用户信息")
    @PostMapping(value = "/selectById")
    @ResponseBody
    public Result selectById(@RequestBody @Valid ClassroomDto classroomDto) {
        Classroom classroom=classroomMapper.selectById(28);
        return Result.OK(classroom);
    }

}
