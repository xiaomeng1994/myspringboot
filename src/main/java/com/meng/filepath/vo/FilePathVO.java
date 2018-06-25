package com.meng.filepath.vo;

public class FilePathVO {

    //id
    private String dirFileId;
    //部门id
    private String depId;
    //文件名称
    private String fileName;
    //上级目录
    private String parent;
    //文件或目录类型
    private String docDirType;
    //文档后缀
    private String docExt;
    //相对路径
    private String relPath;
    //字节大小
    private long fileSize;

    public String getDirFileId() {
        return dirFileId;
    }

    public void setDirFileId(String dirFileId) {
        this.dirFileId = dirFileId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDocDirType() {
        return docDirType;
    }

    public void setDocDirType(String docDirType) {
        this.docDirType = docDirType;
    }

    public String getDocExt() {
        return docExt;
    }

    public void setDocExt(String docExt) {
        this.docExt = docExt;
    }

    public String getRelPath() {
        return relPath;
    }

    public void setRelPath(String relPath) {
        this.relPath = relPath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FilePathVO{" +
                "dirFileId='" + dirFileId + '\'' +
                ", depId='" + depId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", parent='" + parent + '\'' +
                ", docDirType='" + docDirType + '\'' +
                ", docExt='" + docExt + '\'' +
                ", relPath='" + relPath + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
