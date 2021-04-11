package com.ticketservice.img.interfaces.facade;

import com.ticketservice.img.domain.service.ImageService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-10-30
 */
@RestController
@RequestMapping("/img")
@Slf4j
@Api(tags="ImageFacade图片处理")
public class ImageFacade {
    @Autowired
    ImageService imageService;

    /**
     * 直接返回图片输出流,通过url即可访问图片
     * @param response
     */
    @GetMapping(value = "/scenic/base64/{fileName}")
    @ApiOperation("获取景点图片，response返回")
    public void getScenicImgById(@PathVariable("fileName") String fileName, HttpServletResponse response) {
         response.setContentType("image/jpg");
         String scenicImagePath = imageService.getScenicPath()+"/"+fileName;
        imageService.responseImageByFullPath(scenicImagePath,response);
    }
    @GetMapping(value = "/user/base64/{fileName}")
    @ApiOperation("获取用户图片,response返回")
    public void getUserImgById(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        response.setContentType("image/jpg");
        String userImagePath = imageService.getUserPath()+"/"+fileName;
        imageService.responseImageByFullPath(userImagePath,response);
    }

    @GetMapping(value="/user/{fileName}",produces =  org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation("获取用户图片")
    public byte[] getUserImageFileByName(@PathVariable("fileName")String fileName){
        String userImagePath = imageService.getUserPath()+"/"+fileName;
        return imageService.getImageFileByte(userImagePath);
    }
    @GetMapping(value="/scenic/{fileName}",produces =  org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation("获取景点图片")
    public byte[] getScenicImageFileByName(@PathVariable("fileName")String fileName){
        String userImagePath = imageService.getScenicPath()+"/"+fileName;
        return imageService.getImageFileByte(userImagePath);
    }

    //添加注解后swagger-ui才会显示上传图片控件
    @ApiOperation(value = "图片上传",notes = "图片上传测试，用于传输多个文件",consumes = "multipart/form-data",response = Object.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", paramType="form", value = "临时文件", dataType="file", collectionFormat="array", required = true),
    })
    @PostMapping(value = "/test",headers = "content-type=multipart/form-data")
    public Object uploadFileSample(@ApiParam(value="文件",required=true) @RequestPart("file")MultipartFile[] file){
        //上传多个文件
        System.out.println("uploadFileSample----file = " + Arrays.deepToString(file));
        return null;
    }

    //返回图片的Base64编码，一般不用，前端还必须解码
    @GetMapping(value = "/read-img/user/{fileName}")
    @ApiOperation("返回图片64编码")
    public String imgToBase64(@PathVariable("fileName")String fileName) {
        String userImagePath = imageService.getUserPath()+"/"+fileName;
        return imageService.toImageBase64(userImagePath);
    }
    @ApiOperation(value="上传用户图片",consumes = "multipart/form-data",response = Object.class)
    @ApiImplicitParam(name = "file", paramType="form", value = "临时文件", dataType="file", collectionFormat="array", required = true)
    @ResponseBody
    @PostMapping(value = "/upload/user")
    //用@RequestPart取代@RequestParam，否则在swagger-ui中无法显示上传控件
    public String uploadUserImage(@ApiParam(value="文件",required=true) @RequestPart(value = "file") MultipartFile file) throws Exception{
        String scenicBasePath = imageService.getScenicPath();
        String newFileName =  imageService.uploadService(file,scenicBasePath);
        String url = imageService.getUserImageBaseURL()+"/"+newFileName;
        return url;
    }

    @ResponseBody
    @PostMapping(value = "/upload/scenic",headers = "content-type=multipart/form-data")
    @ApiOperation(value="上传景点图片",consumes = "multipart/form-data",response = Object.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", paramType="form", value = "上传图片", dataType="file",  required = true),
    })
    //用@RequestPart取代@RequestParam
    public String uploadScenicImage(@ApiParam(value="文件",required=true)@RequestPart(value = "file") MultipartFile file) throws Exception{
       String scenicBasePath = imageService.getScenicPath();
       String newFileName =  imageService.uploadService(file,scenicBasePath);
       String url = imageService.getSecnicImageBaseURL()+"/"+newFileName;
       return url;
    }

}
