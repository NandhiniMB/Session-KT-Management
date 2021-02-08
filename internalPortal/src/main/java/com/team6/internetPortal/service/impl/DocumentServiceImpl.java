package com.team6.internetPortal.service.impl;

import com.team6.internetPortal.config.DocumentStorageProperty;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class DocumentServiceImpl {

    private final Path docStorageLocation;

    @Autowired
    public DocumentServiceImpl(DocumentStorageProperty documentStorageProperty) throws IOException {
        this.docStorageLocation = Paths.get(documentStorageProperty.getUploadDirectory()).toAbsolutePath().normalize();
        Files.createDirectories(this.docStorageLocation);
;    }

    public String saveFile(MultipartFile multipartFile, String fileName) throws IOException {
        Date date = new Date();
        int index = fileName.indexOf(".");
        String name = fileName.substring(0, index) + date.getTime() + fileName.substring(index);
        Path targetLocation = this.docStorageLocation.resolve(name);
        Files.copy(multipartFile.getInputStream(), targetLocation);
        return targetLocation.toString();
    }

    public byte[] retrieveFile(String path){
        File file = new File(path);
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            byte fileContent[] = new byte[(int)file.length()];
            fileInputStream.read(fileContent);
            return fileContent;
        } catch(Exception e){

        }
        return null;
    }
}
