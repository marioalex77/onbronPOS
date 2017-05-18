package com.maguzman.onbron.beans;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by maguzman on 18/05/2017.
 */
public class FileBucket {
    MultipartFile file;

    String description;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
