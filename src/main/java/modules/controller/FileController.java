package modules.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import modules.util.aliyunFile.AliyunOSSUtil;
import modules.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * <p>
 *  文件上传
 * </p>
 *
 * @author kangshizhu
 * @since 2022-09-16
 */
@Api(tags = "阿里云文件上传接口")
@RestController
@RequestMapping("/file")
public class FileController {




    /**
     * 阿里云文件上传
     * @param files
     * @return
     */
    @ApiOperation("阿里云单个文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(MultipartFile files) throws Exception {

        File file = null;
        try {
            //MultipartFile 转file
            String originalFilename = files.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            file = File.createTempFile(filename[0], filename[1]);    //注意下面的 特别注意！！！
            files.transferTo(file);
            file.deleteOnExit();
            //返回阿里云文件路径
            String url=AliyunOSSUtil.OSSUploadFile(file);
            return Result.OK(url);
        } catch (Exception e) {
            throw new Exception("文件转化失败");
        }
    }

}
