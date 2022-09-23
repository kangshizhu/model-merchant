package modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import modules.entity.ShopEvaluationList;
import modules.vo.Result;

/**
 * <p>
 * 商品测评列表 服务类
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-22
 */
public interface IShopEvaluationListService extends IService<ShopEvaluationList> {


    Result pushShop(ShopEvaluationList shopEvaluationList);


}
