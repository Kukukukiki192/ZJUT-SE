package com.company;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageScaling {

    public static Image zoom(String srcPath, double d) {

        BufferedImage src;
        Image image = null;
        try {
            src = ImageIO.read(new File(srcPath));
            int width = src.getWidth(); // 源图宽
            int height = src.getHeight(); // 源图高

            // 获取一个宽、长是原来scale的图像实例
            image = src.getScaledInstance((int) (width * d),
                    (int) (height * d), Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
