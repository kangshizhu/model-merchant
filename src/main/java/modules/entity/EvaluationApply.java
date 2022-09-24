package modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测评商品申请表
 * </p>
 *
 * @author chenguitong
 * @since 2022-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EvaluationApply对象", description="测评商品申请表")
public class EvaluationApply extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品申请ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申请用户ID")
    private Long userId;

    @ApiModelProperty(value = "商品测评ID")
    private Long evaluationId;

    @ApiModelProperty(value = "申请状态;默认0,待审核，1,审核通过，2,审核不通过")
    private String applyStatus;

    @ApiModelProperty(value = "收货人")
    private String userName;

    @ApiModelProperty(value = "收货手机号")
    private String userPhone;

    @ApiModelProperty(value = "收获地址")
    private String userAddress;

    @ApiModelProperty(value = "品牌商ID")
    private Long merchantId;


}
