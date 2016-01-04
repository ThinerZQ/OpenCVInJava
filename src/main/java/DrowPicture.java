import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import util.ImageUtils;

/**
 * Created by zhengshouzi on 2016/1/4.
 */
public class DrowPicture {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        int thickness =2;
        int lineType =8;

        Mat mat = Imgcodecs.imread("beautiful.jpeg");

        Imgproc.ellipse(mat,new Point(300,300),new Size(125,125),26,0,360,new Scalar(255,129,0),thickness,lineType,2);

        ImageUtils.showPicture(mat,".jpeg");


    }
}
