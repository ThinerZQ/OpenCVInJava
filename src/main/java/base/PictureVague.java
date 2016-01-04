package base;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import util.ImageUtils;

/**
 * Created by zhengshouzi on 2016/1/3.
 */
public class PictureVague {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat srcImage = Imgcodecs.imread("beautiful.jpeg");

        ImageUtils.showPicture(srcImage, ".jpeg");

        Mat dstImage = new Mat();

        Imgproc.blur(srcImage, dstImage, new Size(7, 7));

        ImageUtils.showPicture(dstImage, ".jpeg");

    }

}
