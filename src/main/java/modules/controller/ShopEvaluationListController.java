package modules.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import modules.dto.ShopEvaluationListDto;
import modules.entity.ShopEvaluationList;
import modules.service.ICompanyRegisterInfoService;
import modules.service.IShopEvaluationListService;
import modules.util.EvaluationConstant;
import modules.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品测评列表 前端控制器
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-22
 */
@RestController
@RequestMapping("/shoEvaluationList")
public class ShopEvaluationListController {

    @Resource
    IShopEvaluationListService shopEvaluationListService;

    @Resource
    ICompanyRegisterInfoService iCompanyRegisterInfoService;

    @ApiOperation(value = "发布测评商品", notes = "发布测评商品")
    @PostMapping(value = "/pushShop")
    @ResponseBody
    public Result pushShop(@RequestBody ShopEvaluationListDto shopEvaluationListDto){
        ShopEvaluationList evaluationList = new ShopEvaluationList();
        BeanUtils.copyProperties(shopEvaluationListDto,evaluationList);
        return shopEvaluationListService.pushShop(evaluationList);
    }

    @ApiOperation(value = "停止商品测评", notes = "终止测评商品,只传入测评商品ID即可")
    @PostMapping(value = "/shopEnd")
    @ResponseBody
    public Result shopEnd(@RequestBody ShopEvaluationListDto shopEvaluationListDto){
        ShopEvaluationList evaluationList = new ShopEvaluationList();
        BeanUtils.copyProperties(shopEvaluationListDto,evaluationList);
        evaluationList.setStatus(EvaluationConstant.DISENABLE_STATUS);
        shopEvaluationListService.updateById(evaluationList);
        return Result.OK("测评已终止!");
    }

    @ApiOperation(value = "查询商品测评列表", notes = "查询对应商户下的所有商品测评列表")
    @PostMapping(value = "/getShopList")
    @ResponseBody
    public Result getShopList(@RequestBody ShopEvaluationListDto shopEvaluationListDto) {
        Page<ShopEvaluationList> page=new Page<>(shopEvaluationListDto.getCurrent(),shopEvaluationListDto.getSize());
        QueryWrapper<ShopEvaluationList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("company_id",shopEvaluationListDto.getMerchantId());
        IPage<ShopEvaluationList> shopEvaluationListIPage = shopEvaluationListService.page(page,queryWrapper);
        return Result.OK(shopEvaluationListIPage);
    }

    @ApiOperation(value = "查询所有商品测评列表", notes = "查询所有商品测评列表")
    @PostMapping(value = "/getAllShopList")
    @ResponseBody
    public Result getAllShopList(@RequestBody ShopEvaluationListDto shopEvaluationListDto) {
        Page<ShopEvaluationList> page=new Page<>(shopEvaluationListDto.getCurrent(),shopEvaluationListDto.getSize());
        IPage<ShopEvaluationList> shopEvaluationListIPage = shopEvaluationListService.page(page);
        return Result.OK(shopEvaluationListIPage);
    }




}
