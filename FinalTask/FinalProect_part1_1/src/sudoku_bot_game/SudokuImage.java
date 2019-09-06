package sudoku_bot_game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SudokuImage {

    static BufferedImage im;
    static BufferedImage start;

    static  BufferedImage key0;
    static  BufferedImage key1;
    static  BufferedImage key2;
    static  BufferedImage key3;
    static  BufferedImage key4;
    static  BufferedImage key5;
    static  BufferedImage key6;
    static  BufferedImage key7;
    static  BufferedImage key8;
    static  BufferedImage key9;

    static {
        try {
            start = ImageIO.read(new File ("start.png"));
            key0 = ImageIO.read(new File ("key0.png"));
            key1 = ImageIO.read(new File ("key1.png"));
            key2 = ImageIO.read(new File ("key2.png"));
            key3 = ImageIO.read(new File ("key3.png"));
            key4 = ImageIO.read(new File ("key4.png"));
            key5 = ImageIO.read(new File ("key5.png"));
            key6 = ImageIO.read(new File ("key6.png"));
            key7 = ImageIO.read(new File ("key7.png"));
            key8 = ImageIO.read(new File ("key8.png"));
            key9 = ImageIO.read(new File ("key9.png"));

        } catch (IOException e) {
            System.out.println("Error enter key" + e);
        }
    }


}
