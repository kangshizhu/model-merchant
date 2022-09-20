package modules.util.aliyunFile;

import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author:kangshizhu
 * @create:2022/9/19-17:21
 **/
public class OSSFile {

    @Excel(name = "文件名称")
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @Excel(name = "文件地址")
    @ApiModelProperty(value = "文件地址")
    private String url;
}
