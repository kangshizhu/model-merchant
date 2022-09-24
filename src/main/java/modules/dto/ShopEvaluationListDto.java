package modules.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import modules.entity.BaseEntity;

/**
 * Author：感觉自己是巨星
 * Date：2022-09-22-10:35
 * Description：<描述>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ShopEvaluationList对象", description="")
public class ShopEvaluationListDto  extends BaseEntity {

    @ApiModelProperty(value = "商品测评id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品详情描述")
    private String note;

    @ApiModelProperty(value = "商品图片集合")
    private String images;

    @ApiModelProperty(value = "可申请数量")
    private Long nums;

    @ApiModelProperty(value = "状态(1,启用;0,停止);1,启用;0,停止")
    private String status;

    @ApiModelProperty(value = "品牌商ID")
    private Long merchantId;

    @ApiModelProperty(value = "分页查询")
    private Long current;

    @ApiModelProperty(value = "分页大小")
    private Long size;

}
