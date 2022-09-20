package modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Classroom对象", description="班级表")
@TableName("classroom")
public class Classroom extends BaseEntity {



    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotBlank(message = "学生名称不能为空")
    @ApiModelProperty(value = "姓名",required = true)
    private String usernames;
    @NotBlank(message = "学生名称不能为空")
    @ApiModelProperty(value = "价格",required = true)
    private String price;
    @NotBlank(message = "学生名称不能为空")
    @ApiModelProperty(value = "宿舍",required = true)
    private String context;


}
