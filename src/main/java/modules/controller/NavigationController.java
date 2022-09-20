package modules.controller;


import io.swagger.annotations.ApiOperation;
import modules.dto.NavigationDto;
import modules.entity.Navigation;
import modules.mapper.NavigationMapper;
import modules.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  导航栏
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
@RestController
@RequestMapping("/navigation")
public class NavigationController {

    @Resource
    NavigationMapper navigationMapper;

    @ApiOperation(value = "导航栏添加", notes = "商户导航栏添加")
    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(@RequestBody @Valid NavigationDto nvigationDto) {
        Navigation navigation=new Navigation();
        BeanUtils.copyProperties(nvigationDto,navigation);
        navigationMapper.insert(navigation);
        return Result.OK("添加成功");
    }

}
