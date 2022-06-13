package com.tuling.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    private final static String utf8 ="utf-8";
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //分片
        response.setCharacterEncoding(utf8);
        Integer schunk = null; // 当前分片数
        Integer schunks = null;// 总分片数
        String name = null;
        String uploadPath = "F:\\fileItem";
        BufferedOutputStream os = null;
        try{
            /**
             * 由 org.apache.commons.fileupload.FileItemFactory 接口的默认实现
             * org.apache.commons.fileupload.disk.DiskFileItemFactory 来完成。当上传的文件项目比较小时，
             * 直接保存在内存中（速度比较快），比较大时，以临时文件的形式，保存在磁盘临时文件夹（虽然速度慢些，但是内存资源是有限的）。
             * https://www.cnblogs.com/w-wfy/p/6239330.html
             */
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            //设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            factory.setSizeThreshold(1024);
              /*//设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);*/
            factory.setRepository(new File(uploadPath));

            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
            upload.setFileSizeMax(5l *1024l *1024l*1024l);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            upload.setSizeMax(10l *1024l *1024l*1024l);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> items = upload.parseRequest(request);

            // 现从表单域中取文件分片信息
            for(FileItem item : items){
                //如果fileitem中封装的是普通输入项的数据 isFormField表示不是文件对象，是表单域，可以在里面取出分片信息
                if(item.isFormField()){
                    if("chunk".equals(item.getFieldName())){
                        schunk = Integer.parseInt(item.getString(utf8));
                    }
                    if("chunks".equals(item.getFieldName())){
                        schunks = Integer.parseInt(item.getString(utf8));
                    }
                    if("name".equals(item.getFieldName())){
                        name = item.getString(utf8);
                    }
                }
            }
            // 在根据分片信息取文件
            for(FileItem item : items){
                if(!item.isFormField()){
                    String temFileName = name;
                    if(name != null){
                        if(schunk != null){
                            temFileName = schunk +"_"+name;
                        }
                        File temFile = new File(uploadPath,temFileName);
                        if(!temFile.exists()){//断点续传
                            item.write(temFile);
                        }
                    }
                }
            }
            //文件合并
            // 判断是否有份片，有份片并且上传的是最后一个分片才合并
            //schunk.intValue() 当前分片数
            if(schunk != null && schunk.intValue() == schunks.intValue()-1){
                File tempFile = new File(uploadPath,name);
                os = new BufferedOutputStream(new FileOutputStream(tempFile));

                for(int i=0 ;i<schunks;i++){
                    // 前端上传文件规则：分片数+"_"+文件名称
                    File file = new File(uploadPath,i+"_"+name);
                    while(!file.exists()){// 要所有合并文件存在，才合并 ，因为也有最后一个分片上传成功，还有其他分片还没上传完成的情况
                        Thread.sleep(100);
                    }
                    byte[] bytes = FileUtils.readFileToByteArray(file);
                    os.write(bytes);
                    os.flush();
                    file.delete();
                }
                os.flush();
            }
            response.getWriter().write("上传成功"+name);
        }finally {
            try{
                if(os != null){
                    os.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
