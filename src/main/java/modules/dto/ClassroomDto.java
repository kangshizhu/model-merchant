package modules.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import modules.entity.BaseEntity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Classroom对象", description="")
public class ClassroomDto extends BaseEntity  {


    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名",required = true)
    private String usernames;

    @NotBlank(message = "价格不能为空")
    @ApiModelProperty(value = "价格",required = true)
    private String price;

    @NotBlank(message = "学生名称不能为空")
    @ApiModelProperty(value = "宿舍",required = true)
    private String context;


}
