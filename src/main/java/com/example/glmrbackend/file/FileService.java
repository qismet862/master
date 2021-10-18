package com.example.glmrbackend.file;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileService {
    public String writeBase64EncodedStringToFile(String image,String url) throws IOException {
        if(image==null){
            return null;
        }
        String fileName = generateRandomName();
        File target = new File(url+ fileName);
        OutputStream outputStream = new FileOutputStream(target);
        byte[] base64encoded = Base64.getMimeDecoder().decode(image.split(",")[1]);
        outputStream.write(base64encoded);
        outputStream.close();
        return fileName;
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
