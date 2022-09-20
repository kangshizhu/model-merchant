package modules.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2022-09-17
 */
@Data
@Accessors(chain = true)
@ApiModel(value="Navigation对象", description="导航栏")
@TableName("navigation")        
public class NavigationDto {




    @NotBlank(message = "导航栏名称不能为空")
    @ApiModelProperty(value = "导航栏名称",required = true)
    private String labelName;


    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序",required = true)
    private Integer sort;



}
