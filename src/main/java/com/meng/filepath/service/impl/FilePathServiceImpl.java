package com.meng.filepath.service.impl;

import com.meng.filepath.mapper.FilePathMapper;
import com.meng.filepath.service.FilePathService;
import com.meng.filepath.vo.FilePathVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service("filePathService")
public class FilePathServiceImpl implements FilePathService {

    @Resource
    private FilePathMapper filePathMapper;
    //中文字符转化成对应的什么字符
    private static Map<String,String> map = new HashMap<String,String>();

    static {
        map.put("0","0");
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");
        map.put("6","6");
        map.put("7","7");
        map.put("8","8");
        map.put("9","9");
        map.put("（","(");
        map.put("(","(");
        map.put("）",")");
        map.put(")",")");
        map.put("【","[");
        map.put("[","[");
        map.put("】","]");
        map.put("]","]");
        map.put("、","-");
        map.put("-","-");
        map.put(".",".");
        map.put("《","(");
        map.put("》",")");
    }

    /**
     * 递归重命名
     * @param filePath
     */
    public void insertFilePathBydir(String filePath){
        FilePathVO filePathVO = new FilePathVO();
        this.cirle(filePath,filePathVO);
    }

    /**
     * 递归重命名
     * @param filePath
     */
    public void clearFileContentByPath(String filePath){
        FilePathVO filePathVO = new FilePathVO();
        this.cirle(filePath,filePathVO);
    }


    /**
     *  递归循环遍历
     */
    private void cirle(String path,FilePathVO filePathVO){
        FilePathVO currentVO = new FilePathVO();
        currentVO.setDirFileId(UUID.randomUUID().toString().replace("-",""));
        currentVO.setDepId("TEST1");
        currentVO.setParent(filePathVO.getDirFileId());
        //创建当前路径的file
        File file = new File(path);
        //获取父路径
        Path parentPath = Paths.get(file.getParent()).resolve("").toAbsolutePath();
        //得到当前路径的英文路径file
        String currentPath =  this.spell(file.getName(),map);
        File currentFile = null;
        int index = 0;
        do{
            //临时文件的绝对路径，判断是否存在
            StringBuilder templeCurrentPath = new StringBuilder(parentPath.toAbsolutePath().toString());
            templeCurrentPath.append(File.separator);
            templeCurrentPath.append(currentPath);
            //当有重复的文件夹或文件加上如(1)这样区分
            if(0 < index){
                templeCurrentPath.append("(").append(index).append(")");
            }
            //取得后缀
            if(file.getName().lastIndexOf(".") > -1){
                templeCurrentPath.append(file.getName().substring(file.getName().lastIndexOf(".")+1));
            }
            //System.out.println("" + file.getPath() + "-----:" + currentPath);
            currentFile = new File(templeCurrentPath.toString());
            index++;
        }while (currentFile.exists());
        //重命名
        file.renameTo(currentFile);
        //设置文件名称
        currentVO.setFileName(file.getName());
        //设置理解
        currentVO.setRelPath(currentFile.getPath());
        //判断是否为文件
        if(currentFile.isFile()){
            currentVO.setDocDirType("FILE");
            currentVO.setDocExt(currentFile.getName().substring(currentFile.getName().lastIndexOf(".")+1));
            currentVO.setFileSize(currentFile.length());
            //System.out.println("----------file:" + file.getPath() + "-----englishName:" + this.spell(file.getName()));
        //文件夹
        } else{
            currentVO.setDocDirType("DIR");
            //System.out.println("----------dir:" + file.getPath() + "-----englishName:" + this.spell(file.getName()));
            File[] files = currentFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.cirle(currentFile.getPath() + File.separator + files[i].getName(),currentVO);
            }
        }
        //System.out.println(currentVO);
        //插入数据库
        this.filePathMapper.insertFilePath(currentVO);

    }

    /**
     * 递归清空文件夹下文件内容的数据
     * @param path
     */
    private void clearFileContent(String path) throws Exception {
        File file = new File(path);
        if(file.isFile()){
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write("".getBytes());
            //文件夹
        } else{
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.clearFileContent(file.getPath() + File.separator + files[i].getName());
            }
        }
    }

}
