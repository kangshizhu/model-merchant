package modules.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import modules.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * Author：感觉自己是巨星
 * Date：2022-09-20-14:40
 * Description：<描述>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CompanyRegister对象", description="")
public class CompanyRegisterDto extends BaseEntity {

    @ApiModelProperty(value = "商户类型(1:个体工商户、2:企业/公司)")
    private String companyType;

    @ApiModelProperty(value = "营业执照")
    private String companyImage;

    @ApiModelProperty(value = "公司名称/商户名")
    private String companyName;

    @ApiModelProperty(value = "统一社会信用代码")
    private String unifiedCode;

    @ApiModelProperty(value = "营业期限(失效日期)")
    private LocalDateTime companyDate;

    @ApiModelProperty(value = "公司地址")
    private String companyAddress;

    @ApiModelProperty(value = "经营者身份归属地")
    private String businessPlaceIdentity;

    @ApiModelProperty(value = "经营者身份证照片正面")
    private String businessImagePositive;

    @ApiModelProperty(value = "经营者身份证照片反面")
    private String businessImageSide;

    @ApiModelProperty(value = "经营者姓名")
    private String businessName;

    @ApiModelProperty(value = "经营者身份证号码")
    private String businessCode;

    @ApiModelProperty(value = "注册id(PK)")
    @TableId(value = "company_id", type = IdType.AUTO)
    private Long companyId;

    @ApiModelProperty(value = "经营者身份证开始日期")
    private String businessCodeStart;

    @ApiModelProperty(value = "经营者身份证截止日期")
    private String businessCodeEnd;
}
