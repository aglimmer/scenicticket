package com.ticketservice.img.domain.service;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-10-30
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix="img")
public class ImageService {

    @Value("${img.base-url}")
    private  String baseUrl;
    @Value("${img.user-path}")
    private  String userPath;
    @Value("${img.scenic-path}")
    private  String scenicPath;
    //计算表达式
    @Value("${img.max-size}")
    private long maxSize;
    public  String getUserImageBaseURL(){
        return baseUrl +"/user";
    }
    public  String getSecnicImageBaseURL(){
        return baseUrl +"/scenic";
    }

    public void responseImageByFullPath(String fullPath, HttpServletResponse response){
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(fullPath);
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 上传图片
     * 其中basePath为上传的目录
     * @Return 保存后的新文件名称
     * @param file
     */
    public String uploadService(MultipartFile file,String basePath) {
        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 新文件名
        String newFileName = UniqueID.getId()+suffixName;
        File dest = new File(basePath +"/"+ newFileName);
        log.info("图片文件保存位置："+dest.getAbsolutePath());
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            InputStream fileInputStream = file.getInputStream();
            FileCopyUtils.copy(fileInputStream, Files.newOutputStream(dest.toPath()));

//            int size = fileInputStream.available();
//            byte []bytes = new byte[size];
//            FileOutputStream fileOutputStream = new FileOutputStream(dest);
//            fileOutputStream.write(bytes,0,size);
            //file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //保存到数据库
        log.info("上传成功");
        return newFileName;

    }

    /**
     * 把base64编码图片字符串保存为图片
     **/
    public String saveBase64Image(String image) {
 		//文件头部信息形式
		//String header = "data:image/jpeg;base64,";
        String header = "data:image/";
		//找不到以字符串 header，说明不是图片
        if (!image.startsWith(header)) {
            return null;
        }
        int pos = image.indexOf(";");
        String imgtype = image.substring(header.length(),pos);
        System.out.println("图片类型："+imgtype);
 		//去掉头部
        image = image.substring(image.indexOf(",")+1);
        System.out.println("去除头部："+image);
        BASE64Decoder decoder = new BASE64Decoder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		//生成一个文件名
        String fileName = formatter.format(LocalDateTime.now())+"."+imgtype;
		//设置图片保存路径
        String imgFolder = this.getScenicPath();
        String imgFilePath = imgFolder+"/"+fileName;
        try {
            // 对字节数组字符串进行Base64解码并生成图片
            byte[] decodedBytes = decoder.decodeBuffer(image);
            FileOutputStream out = new FileOutputStream(imgFilePath);
			//把图片写入文件
            out.write(decodedBytes);
            out.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
			//返回json类型
            return null;
			//e.printStackTrace();
        }
		//返回文件名称
        return fileName;

    }
    /**
     * 将图片转为base64编码
     **/
    public String toImageBase64(String imageFile) {
        String msg = null;
        int pos = imageFile.lastIndexOf(".")+1;
        String fileType = imageFile.substring(pos);

        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imageFile);
            //in.available()计算字节大小
            data = new byte[in.available()];
            //InputStream把数据读取到字节数组中
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        if (data != null) {
            //返回Base64编码过的字节数组字符串
            String res = "data:image/"+fileType+";Base64,"+encoder.encode(data);

            return "data:image/jpeg;base64," + encoder.encode(data);
        }
        return null;
    }
    /**
     * 读取图片为字节
     **/
    public byte[] getImageFileByte(String imageFile) {
        File file = new File(imageFile);
        System.out.println("imageFile = " + imageFile);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取文件失败");
        }
        System.out.println("无法获取图片");
        return null;
    }
    /**
     * 上传文件
     **/
    public void uploadFile(String filePath, InputStream inputStream){
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            dest.createNewFile();
            FileCopyUtils.copy(inputStream, Files.newOutputStream(dest.toPath()));
        } catch (IOException e) {
            dest.delete();
            System.out.println("上传失败");
        }

    }
    /**
     * 上传文件
     **/
    public String uploadScenicImageFile(MultipartFile file) {
        long maxSize = 1024*1024*3;
        try {
            if (file == null) {
                throw new Exception("没有上传有效文件");
            }
            if (file.getSize() >= maxSize) {
                throw new Exception("文件大小超过了最大限制:maxSize="+maxSize);
            }
            //原文件名
            final String originalFilename = file.getOriginalFilename();
            final InputStream inputStream = file.getInputStream();
            //新文件名
            String newFileName = UniqueID.getId()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //放置文件位置
            String filePath = this.getScenicPath()+"/"+newFileName;
            uploadFile(filePath, inputStream);
            String imageUrl = this.getSecnicImageBaseURL()+"/"+newFileName;
            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        String imageFile = "upload/user_img/0041.jpg";
//       String image64 =  new ImageService().toImageBase64(imageFile);
//        System.out.println(image64);
//    }
}
