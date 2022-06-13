



 在JAVA项目中，经常需要做一些FTP的操作，如向FTP上传文件、下载文件、文件重命名、文件删除、创建文件夹等等，本文简单介绍如何利用jakarta commons中的FTPClient（在commons-net包中）实现上传下载重命名等操作文件。

如果是使用MAVEN管理项目则添加

<dependency>
<groupId>org.apache.camel</groupId>
<artifactId>camel-ftp</artifactId>
<version>2.13.2</version>
</dependency>



来源： http://blog.csdn.net/dzy784858512/article/details/41279709

这两个apache的jar包：

![image-20211119104737646](/Users/changxiong/Downloads/%E8%B5%84%E6%96%99/java%E9%AB%98%E7%BA%A7/ftp/ftp.assets/image-20211119104737646.png)

```java
package com.cn.test;


import java.io.*;


import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;


/**
 * @author Administrator
 * @create 2017 09 12 20:52
 */
public class FtpUtils {


    @Test//上传文件
    public void upFtp() throws IOException {
        boolean result = upload("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "E:\\cx.txt", "cx.txt");
        System.out.println(result);
    }


    @Test//显示目录
    public  void  showList() throws IOException {
        String[] lists = list("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download");
        for (String list : lists) {
            System.out.println(list.toString());


        }
    }




    @Test//下载文件
    public void downFtp() throws IOException {
        boolean result = download("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "test.txt", "E:\\test.txt");
        System.out.println(result);
    }


    @Test//重命名文件
    public void chmodName() throws IOException {
        boolean result = rename("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "cx.txt", "changxiong.txt");
        System.out.println(result);
    }


    @Test//删除文件夹
    public void deleteFlie() throws IOException {
        boolean result = remove("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "changxiong.txt");
        System.out.println(result);
    }


    @Test//创建目录
    public void createDestory() throws IOException {
        boolean result = makeDirecotory("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "mml");
        System.out.println(result);
    }


    @Test//修改文件夹的名字
    public void renamePath() throws IOException {
        boolean result = renameDirecotory("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "mml","llj");
        System.out.println(result);
    }


    @Test//删除目录名
    public void deleteFileName() throws IOException {
        boolean result = removeDirecotory("10.180.221.106", "ftp_cx", 21, "520",
                "E:\\ftp\\Download", "llj");
        System.out.println(result);
    }




    /**
     * ftp上传单个文件
     * @param ftpUrl
    ftp地址
     * @param userName
    ftp的用户名
     * @param password
    ftp的密码
     * @param directory
    上传至ftp的路径名不包括ftp地址
     * @param srcFileName
    要上传的文件全路径名
     * @param destName
    上传至ftp后存储的文件名
     * @throws IOException
     */
    public static boolean upload(String ftpUrl,String userName,int port,
                                 String password,String directory,String srcFileName,String destName) throws IOException {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        boolean result = false;
        try {
            ftpClient.connect(ftpUrl, port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            File srcFile = new File(srcFileName);
            fis = new FileInputStream(srcFile);
            // 设置上传目录
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("gbk");
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            result = ftpClient.storeFile(destName, fis);
            return result;
        } catch (NumberFormatException e) {
            System.out.println("FTP端口配置错误:不是数字:");
            throw e;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }


    }








    /**
     * FTP单个文件下载
     * @param ftpUrl
    ftp地址
     * @param userName                ftp的用户名
     * @param password                ftp的密码
     * @param directory               要下载的文件所在ftp的路径名不包含ftp地址
     * @param destFileName            要下载的文件名
     * @param downloadName            下载后锁存储的文件名全路径
     */
    public static boolean download(String ftpUrl,String userName,int port,
                                   String password,String directory,String destFileName,String downloadName)throws IOException {
        FTPClient ftpClient = new FTPClient();
        boolean result = false;
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setBufferSize(1024);
        // 设置文件类型（二进制）
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);


            System.out.println("destFileName:" + destFileName + ",downloadName:" + downloadName);
            result = ftpClient.retrieveFile(destFileName, new FileOutputStream(downloadName));
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch(FileNotFoundException e){
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }






    /**
     *
     * @param ftpUrl
    ftp地址
     * @param userName                 ftp的用户名
     * @param password                 ftp的密码
     * @param directory                要重命名的文件所在ftp的路径名不包含ftp地址
     * @param oldFileName              要重命名的文件名
     * @param newFileName              重命名后的文件名
     * @throws IOException
     */
    public static boolean rename(String ftpUrl,String userName,int port,
                                 String password,String directory, String oldFileName, String newFileName) throws IOException {
/**
 * 判断远程文件是否重命名成功，如果成功返回true，否则返回false
 */
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(directory);
            result = ftpClient.rename(oldFileName, newFileName);//重命名远程文件
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }






    /**
     *
     * @param ftpUrl                          ftp地址
     * @param userName                        ftp的用户名
     * @param password                        ftp的密码
     * @param directory                       要删除的文件所在ftp的路径名不包含ftp地址
     * @param fileName                        要删除的文件名
     * @return
     * @throws IOException
     */
    public static boolean remove(String ftpUrl,String userName,int port,
                                 String password,String directory, String fileName) throws IOException
    {
/**
 * 判断远程文件是否移除成功，如果成功返回true，否则返回false
 */
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(directory);
            result = ftpClient.deleteFile(fileName);//删除远程文件
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }






    /**
     *
     * @param ftpUrl              ftp地址
     * @param userName            ftp的用户名
     * @param password            ftp的密码
     * @param directory           要创建的目录所在ftp的路径名不包含ftp地址
     * @param newDirectory
    要创建的新目录名
     * @return
     * @throws IOException
     */
    public static boolean makeDirecotory(String ftpUrl,String userName,int port,
                                         String password,String directory, String newDirectory) throws IOException
    {
/**
 * 判断远程文件是否移除成功，如果成功返回true，否则返回false
 */
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(directory);
            result = ftpClient.makeDirectory(newDirectory);//创建新目录
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }






    /**
     * @param ftpUrl ftp地址
     * @param userName  ftp的用户名
     * @param password  ftp的密码
     * @param directory 要重命名的目录所在ftp的路径名不包含ftp地址
     * @param oldDirectory  要重命名的旧目录名
     * @param newDirectory  重命名后的新目录
     * @return
     * @throws IOException
     */
    public static boolean renameDirecotory(String ftpUrl,String userName,int port,
                                           String password,String directory,String oldDirectory,String newDirectory) throws IOException
    {
/**
 * 判断远程文件是否移除成功，如果成功返回true，否则返回false
 */
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(directory);
            result = ftpClient.rename(oldDirectory,newDirectory);//重命名目录
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }






    /**
     *
     * @param ftpUrl                        ftp地址
     * @param userName                      ftp的用户名
     * @param password                      ftp的密码
     * @param directory                     要重命名的目录所在ftp的路径名不包含ftp地址
     * @param deldirectory                  要删除的目录名
     * @return
     * @throws IOException
     */
    public static boolean removeDirecotory(String ftpUrl,String userName,int port,
                                           String password,String directory,String deldirectory) throws IOException
    {
/**
 * 判断远程文件是否移除成功，如果成功返回true，否则返回false
 */
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(directory);
            result = ftpClient.removeDirectory(deldirectory);//删除目录
            return result;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }




    /**
     *
     * @param ftpUrl
     * @param userName
     * @param password
     * @param directory
     * @return
     * @throws IOException
     */
    public static String[] list(String ftpUrl,String userName,int port,
                                String password,String directory) throws IOException
    {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpUrl,port);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setControlEncoding("gbk");
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.enterLocalPassiveMode();
            String[] list = ftpClient.listNames();//删除目录
            return list;
        } catch(NumberFormatException e){
            throw e;
        } catch (IOException e) {
            throw new IOException("连接ftp服务器失败！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }


}
```

