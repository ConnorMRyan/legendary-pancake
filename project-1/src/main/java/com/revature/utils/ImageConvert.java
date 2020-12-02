package com.revature.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageConvert {

    public static byte[] imageToArray(File file){
        try {
            BufferedImage oldImage = ImageIO.read(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(oldImage, "jpg", bos);
            return bos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage arrayToImage(byte[] image){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(image);
            return  ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
