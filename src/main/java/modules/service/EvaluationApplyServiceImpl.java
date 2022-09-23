package modules.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import modules.entity.EvaluationApply;
import modules.entity.ShopEvaluationList;
import modules.mapper.EvaluationApplyMapper;
import modules.mapper.ShopEvaluationListMapper;
import modules.util.EvaluationConstant;
import modules.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 测评商品申请表 服务实现类
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-22
 */
@Service
public class EvaluationApplyServiceImpl extends ServiceImpl<EvaluationApplyMapper, EvaluationApply> implements IEvaluationApplyService {

    @Resource
    EvaluationApplyMapper evaluationApplyMapper;

    @Resource
    ShopEvaluationListMapper evaluationListMapper;

    @Override
    public Result apply(EvaluationApply evaluationApply) {
        ShopEvaluationList shopEvaluationList = evaluationListMapper.selectById(evaluationApply.getEvaluationId());
        Long nums = shopEvaluationList.getNums();
        QueryWrapper<EvaluationApply> wrapper = new QueryWrapper<>();
        wrapper.eq("evaluation_id",evaluationApply.getEvaluationId());
        Integer applyCount = evaluationApplyMapper.selectCount(wrapper);
        //商品已结束测评则不能申请了
        if(shopEvaluationList ==null || EvaluationConstant.DISENABLE_STATUS.equals(shopEvaluationList.getStatus())){
            return Result.error("申请失败,该商品无法申请测评!");
        }
        //商品数量申请满了也不能再申请了
        if( nums < applyCount){
            return Result.error("申请失败,该商品申请名额已满!");
        }

        //同一个商品一个用户只能申请一次
        QueryWrapper<EvaluationApply> wrapper_exist = new QueryWrapper<>();
        wrapper_exist.eq("evaluation_id",evaluationApply.getEvaluationId());
        wrapper_exist.eq("user_id",evaluationApply.getUserId());
        Integer count = evaluationApplyMapper.selectCount(wrapper_exist);
        if(1 > count){
            evaluationApplyMapper.insert(evaluationApply);
            return Result.OK("申请成功,等待审核!");
        }else{
            return Result.error("申请失败,同一商品同一用户只能申请一次!");
        }


    }

    /*
    * 测评申请审核
    * */
    @Override
    public void approve(List<String> ids, String status) {
        UpdateWrapper<EvaluationApply> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        wrapper.set("apply_status",status);
        evaluationApplyMapper.update(null,wrapper);
    }
}
