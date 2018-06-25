package com.meng.filepath.service.impl;

import com.meng.filepath.mapper.FilePathMapper;
import com.meng.filepath.service.FilePathService;
import com.meng.filepath.vo.FilePathVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service("filePathService")
public class FilePathServiceImpl implements FilePathService {

    @Resource
    private FilePathMapper filePathMapper;
    //中文字符转化成对应的什么字符
    private static Map<String,String> map = new HashMap<String,String>(120);

    //cxjw，jkwww，ncnyw

    //C:\Users\1\Desktop\sj3\kjwwgw\kjwwgw\xmtp


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
        map.put("A","A");
        map.put("B","B");
        map.put("C","C");
        map.put("D","D");
        map.put("E","E");
        map.put("F","F");
        map.put("G","G");
        map.put("H","H");
        map.put("I","I");
        map.put("J","J");
        map.put("K","K");
        map.put("L","L");
        map.put("M","M");
        map.put("N","N");
        map.put("O","O");
        map.put("P","P");
        map.put("Q","Q");
        map.put("R","R");
        map.put("S","S");
        map.put("T","T");
        map.put("U","U");
        map.put("V","V");
        map.put("W","W");
        map.put("X","X");
        map.put("Y","Y");
        map.put("Z","Z");
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        map.put("f","f");
        map.put("g","g");
        map.put("h","h");
        map.put("i","i");
        map.put("j","j");
        map.put("k","k");
        map.put("l","l");
        map.put("m","m");
        map.put("n","n");
        map.put("o","o");
        map.put("p","p");
        map.put("q","q");
        map.put("r","r");
        map.put("s","s");
        map.put("t","t");
        map.put("u","u");
        map.put("v","v");
        map.put("w","w");
        map.put("x","x");
        map.put("y","y");
        map.put("z","z");
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
        this.filePathMapper.truncate();
        String[] deptPath = new String[]{"cxjw","jkwww","ncnyw"};
        String[] path = new String[]{"城乡建设环境与资源保护工委","科教文卫工委","农村农业委"};
        FilePathVO filePathVO = new FilePathVO();
        for (int i = 0; i < path.length; i++) {
            filePathVO.setDepId(deptPath[i]);
            this.cirle(filePath + File.separator + path[i],filePathVO);
        }
    }

    /**
     * 递归重命名
     * @param filePath
     */
    public void clearFileContentByPath(String filePath) throws Exception {
        this.clearFileContent2(filePath);
    }


    /**
     *  递归循环遍历
     */
    private void cirle(String path,FilePathVO filePathVO){
        FilePathVO currentVO = new FilePathVO();
        currentVO.setDirFileId(UUID.randomUUID().toString().replace("-",""));
        currentVO.setDepId(filePathVO.getDepId());
        currentVO.setParent(filePathVO.getDirFileId());
        //创建当前路径的file
        File file = new File(path);
        //当前file
        File currentFile = null;
        //获取父路径
        Path parentPath = Paths.get(file.getParent()).resolve("").toAbsolutePath();
        //得到当前路径的英文路径file
        String currentEnglishName =  "";
        //判断文件名称是否包含中文，不包含不换名字
        if(isContainChinese(file.getName())){
            currentEnglishName = this.spell(file.getName(),map);
            int index = 0;
            do{
                //临时文件的绝对路径，判断是否存在
                StringBuilder templeCurrentPath = new StringBuilder(parentPath.toAbsolutePath().toString());
                templeCurrentPath.append(File.separator);
                templeCurrentPath.append(currentEnglishName);
                //当有重复的文件夹或文件加上如(1)这样区分
                if(0 < index){
                    templeCurrentPath.append("(").append(index).append(")");
                }
                //System.out.println("" + file.getPath() + "-----:" + currentPath);
                currentFile = new File(templeCurrentPath.toString());
                index++;
            }while (currentFile.exists());
            //重命名
            file.renameTo(currentFile);
        //不包含英文名称，使用原来的名称
        }else {
            currentFile = file;
        }
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
        if(file.isFile() && file.exists()){
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write("".getBytes());
            outputStream.close();
            //文件夹
        } else{
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.clearFileContent(file.getPath() + File.separator + files[i].getName());
            }
        }
    }

    /**
     * 递归清空文件夹下文件内容的数据
     * @param path
     */
    private void clearFileContent2(String path) throws Exception {
        File file = new File(path);
        String parentPath = file.getParent();
        String currentName = file.getName();
        File currentFile = null;
        if(file.isFile() && file.exists()){
            String currentEnglishName = this.spell(currentName.substring(0,currentName.lastIndexOf(".")),map);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write("".getBytes());
            outputStream.close();
            int index = 0;
            do{
                //临时文件的绝对路径，判断是否存在
                StringBuilder templeCurrentPath = new StringBuilder(parentPath);
                templeCurrentPath.append(File.separator);
                templeCurrentPath.append(currentEnglishName);
                //当有重复的文件夹或文件加上如(1)这样区分
                if(0 < index){
                    templeCurrentPath.append("(").append(index).append(")");
                }
                //取得后缀
                if(file.getName().lastIndexOf(".") > -1){
                    templeCurrentPath.append(currentName.substring(currentName.lastIndexOf(".")));
                }
                //System.out.println("" + file.getPath() + "-----:" + currentPath);
                currentFile = new File(templeCurrentPath.toString());
                index++;
            }while (currentFile.exists());
            //重命名
            file.renameTo(currentFile);
            //文件夹
        } else{
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.clearFileContent2(file.getPath() + File.separator + files[i].getName());
            }
        }
    }


    /**
     * 判断字符串中是否包含中文
     * @param str
     * 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isContainChinese("test,的!"));
        System.out.println(2398 + 478);
    }

}
