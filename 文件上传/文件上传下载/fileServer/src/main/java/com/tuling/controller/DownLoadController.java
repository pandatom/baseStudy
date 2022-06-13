package com.tuling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class DownLoadController {
    private final static String utf8 ="utf-8";
    @RequestMapping("/download")
    public void downLoadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = new File("C:\\Users\\admin\\nginx原理.mp4");
        response.setCharacterEncoding(utf8);
        InputStream is = null;
        OutputStream os = null;
        try{
            //分片下载   http  Range bytes=0-1000  bytes=100-1000   bytes=100-
            long fSize = file.length();
            response.setContentType("application/x-download");
            String fileName = URLEncoder.encode(file.getName(),utf8);
            response.addHeader("Content-Disposition","attachment;filename=" + fileName);
            response.setHeader("Accept-Range","bytes");

            response.setHeader("fSize",String.valueOf(fSize));
            response.setHeader("fName",fileName);

            // pos 读取的起始位置  last 读取最后位置  sum 总共读取多少
            long pos = 0,last = fSize-1,sum = 0;
            if(null != request.getHeader("Range")){ // 判断是否分片下载
                // 告诉客户端是分片下载
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                // Range两种形式 一种 bytes=100-1000  或者只有起始位置 bytes=100-
                String numRange = request.getHeader("Range").replaceAll("bytes=","");
                String[] strRange = numRange.split("-");
                if(strRange.length == 2){
                    pos = Long.parseLong(strRange[0].trim());
                    last = Long.parseLong(strRange[1].trim());
                    // 如果客户端请求分片结束大小，大于文件大小，那么直接使用文件大小结束
                    if(last > fSize-1){
                        last = fSize-1;
                    }
                }else{
                    pos = Long.parseLong(numRange.replaceAll("-","").trim());
                }
            }
            // 获取需要读取的字节数
            long rangeLenght = last - pos +1;
            String contentRange = new StringBuffer("bytes ").append(pos).append("-").append(last).append("/").append(fSize).toString();
            response.setHeader("Content-Range",contentRange);
            response.setHeader("Content-Lenght",String.valueOf(rangeLenght));

            os = new BufferedOutputStream(response.getOutputStream());
            is = new BufferedInputStream(new FileInputStream(file));
            // 起始位置之前的就不读了，说明已经读取下载过了，使用skip直接跳过
            is.skip(pos);
            byte[] buffer = new byte[1024];
            int lenght = 0;
            while(sum < rangeLenght){
                lenght = is.read(buffer,0,((rangeLenght-sum) <= buffer.length ? ((int)(rangeLenght-sum)) :  buffer.length));
                sum = sum+ lenght;
                os.write(buffer,0,lenght);
            }
            System.out.println("下载完成");
        }finally {
            if(is != null){
                is.close();
            }
            if(os != null){
                os.close();
            }
        }
    }
}
