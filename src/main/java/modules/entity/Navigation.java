package modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import modules.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Navigation对象", description="")
public class Navigation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;



    @ApiModelProperty(value = "导航栏名称")
    private String labelName;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
