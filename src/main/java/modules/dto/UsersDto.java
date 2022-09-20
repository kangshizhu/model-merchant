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
@ApiModel(value="Users对象", description="")
public class UsersDto extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键id",required = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "密码",required = true)
    private String phone;

    @ApiModelProperty(value = "密码",required = true)
    private String password;






}
