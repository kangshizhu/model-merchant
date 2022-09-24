package modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import modules.entity.EvaluationApply;
import modules.vo.Result;

import java.util.List;

/**
 * <p>
 * 测评商品申请表 服务类
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-22
 */
public interface IEvaluationApplyService extends IService<EvaluationApply> {

    Result apply(EvaluationApply evaluationApply);

    void approve(List<String> ids, String status);

}
