package base;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;
import util.ImageUtils;

/**
 * Created by zhengshouzi on 2016/1/3.
 */
public class EdgeDetection {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat srcImage = Imgcodecs.imread("fruit.jpeg");

        ImageUtils.showPicture(srcImage, ".jpeg");

        Mat edge = new Mat();
        Mat grayImage = new Mat();

        //将原图像，转化为灰度图像
        Imgproc.cvtColor(srcImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        //使用 3*3内核降噪
        Imgproc.blur(grayImage, edge, new Size(3, 3));
        //运行Canny算子
        Imgproc.Canny(edge, edge, 3, 9, 3, false);

        //显示图像
        ImageUtils.showPicture(edge, ".jpeg");

    }
}
