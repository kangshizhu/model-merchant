package modules.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import modules.dto.EvaluationApplyDto;
import modules.entity.EvaluationApply;
import modules.service.IEvaluationApplyService;
import modules.service.IShopEvaluationListService;
import modules.util.EvaluationConstant;
import modules.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 测评商品申请表 前端控制器
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-22
 */
@Api(tags = "测评商品申请接口")
@RestController
@RequestMapping("/evaluationApply")
public class EvaluationApplyController {

    @Resource
    IEvaluationApplyService applyService;

    @Resource
    IShopEvaluationListService shopEvaluationListService;


    @ApiOperation(value = "申请商品测评", notes = "申请商品测评")
    @PostMapping(value = "/apply")
    @ResponseBody
    public Result apply(@RequestBody EvaluationApplyDto evaluationApplyDto) {
        EvaluationApply evaluationApply = new EvaluationApply();
        BeanUtils.copyProperties(evaluationApplyDto,evaluationApply);
        return applyService.apply(evaluationApply);
    }


    @ApiOperation(value = "申请通过", notes = "申请通过")
    @PostMapping(value = "/approve")
    @ResponseBody
    public Result approve(@RequestBody String[] evaluationApplyIds) {
        List<String> ids = Arrays.asList(evaluationApplyIds);
        applyService.approve(ids,EvaluationConstant.APPROVE_PASS);
        return Result.OK("操作成功!");
    }

    @ApiOperation(value = "申请不通过", notes = "申请不通过")
    @PostMapping(value = "/approveNoPass")
    @ResponseBody
    public Result approveNoPass(@RequestBody String[] evaluationApplyIds) {
        List<String> ids = Arrays.asList(evaluationApplyIds);
        applyService.approve(ids,EvaluationConstant.APPROVE_NOPASS);
        return Result.OK("操作成功!");
    }






}
