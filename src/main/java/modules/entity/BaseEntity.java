package modules.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description : 基础类包含基础字段
 * @Version 1.0
 */
@Data
public class BaseEntity {

    /**创建人*/
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    /**修改人*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    /**创建时间*/
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    /**修改时间*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
