package com.hong.email;

import java.io.File;

public class EmailMessage {
    public static final String SUBTYPE_MIXED = "mixed";//纯文本,超文本二选一  内嵌资源 附件
    public static final String SUBTYPE_RELATED = "related";//纯文本&纯文本,超文本二选一  内嵌资源
    public static final String SUBTYPE_ALTERNATIVE = "alternative";//纯文本,超文本二选一

    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String content;


    private String titleType;

    private String contentType;

    private File[] files;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
}