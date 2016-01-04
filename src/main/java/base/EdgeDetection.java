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

        //��ԭͼ��ת��Ϊ�Ҷ�ͼ��
        Imgproc.cvtColor(srcImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        //ʹ�� 3*3�ں˽���
        Imgproc.blur(grayImage, edge, new Size(3, 3));
        //����Canny����
        Imgproc.Canny(edge, edge, 3, 9, 3, false);

        //��ʾͼ��
        ImageUtils.showPicture(edge, ".jpeg");

    }
}
