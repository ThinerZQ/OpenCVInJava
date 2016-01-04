package base;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import util.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by zhengshouzi on 2016/1/3.
 */
public class PlayVideo {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(System.getProperty("user.dir"));


        //String filename = System.getProperty("user.dir")+"\\1.mp4";
        // System.out.println(filename);
        VideoCapture videoCapture = new VideoCapture("my.avi");

        videoCapture.open("my.avi");
        System.out.println("ÊÓÆµ´ò¿ª ?" + videoCapture.isOpened());

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setTitle("my.avi");
        frame.pack();
        frame.setVisible(true);

        boolean flag;
        Mat img=new Mat();
        MatOfByte matOfByte=null;
        int i=0;
        do {

            flag = videoCapture.read(img);

            matOfByte = new MatOfByte();
            if (flag == false){
                break;
            }
            Imgcodecs.imencode(".jpeg", img, matOfByte);

            byte[] byteArray = matOfByte.toArray();
            BufferedImage bufImage = null;

            try {
                InputStream in = new ByteArrayInputStream(byteArray);
                bufImage = ImageIO.read(in);
                panel.removeAll();
                panel.updateUI();

                panel.add(new JLabel(new ImageIcon(bufImage)));

                panel.updateUI();

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(i);
        } while (flag);
    }
}
