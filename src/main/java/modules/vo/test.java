//package modules.vo;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClientBuilder;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
///**
// * @description:
// * @author:
// * @create:2022/9/192:09
// **/
//public class test {
//    public static void main(String[] args) throws FileNotFoundException {
//        // Endpoint填写为https://oss-cn-chengdu.aliyuncs.com。
//        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5t7V7FUA3zo4MswXzEZB";
//        String accessKeySecret = "7JYyFcduasWR5xfHj08xl5WWGvV3Lz";
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        String objectname = "file/" + System.currentTimeMillis()+"/demo/";
//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("C:\\Users\\lenovo\\Desktop\\1657697977(1).jpg");
//        //调用oss实现上传第一个参数bucket名称  第二个参数文件名称  第三个参数输入流
//        String url = objectname+"backiee-230432.image";
//        ossClient.putObject("xzcm9999", url, inputStream);
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        //返回组成的文件url
//        String photoUrl = "https://" + "xzcm9999." + "oss-cn-hangzhou.aliyuncs.com"+ "/" + url;
//        System.out.println(photoUrl);
//
//    }
//}
