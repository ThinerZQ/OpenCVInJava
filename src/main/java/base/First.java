package base;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;


import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class First {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //System.load("d:/study/opencv/build/java/x86/opencv_java300.dll");
        // System.load("D:\\Study\\opencv\\build\\x86\\vc12\\bin\\opencv_world300.dll");

        Mat srcImage = Imgcodecs.imread("beautiful.jpeg");


        Mat img = Mat.ones(200, 200, CvType.CV_8UC3);
        img.setTo(new Scalar(255, 255, 255));
        //img.setTo(new Scalar(0, 0, 0));
        Point p1 = new Point(10, 10);
        Point p2 = new Point(150, 150);
        //Rect rect = new Rect(p1, p2);
        // img.create(200, 200, CvType.CV_16U);
        Imgproc.rectangle(img, p1, p2, new Scalar(255, 0, 0), 5);
        Imgproc.line(img, new Point(30, 30), new Point(100, 100), new Scalar(0, 255, 100));
        String filename = "test.jpg";
        Imgcodecs.imwrite(filename, img);


        System.out.println(srcImage.cols());
        showResult(srcImage);

    }

    public static void showResult(Mat img) {
        //Imgproc.resize(img, img, new Size(640, 480));
        MatOfByte matOfByte = new MatOfByte();

        Imgcodecs.imencode(".jpeg", img, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
            JFrame frame = new JFrame();
            frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}