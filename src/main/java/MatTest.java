import org.opencv.core.*;


/**
 * Created by zhengshouzi on 2016/1/4.
 */
public class MatTest {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat r = new Mat(10, 3, CvType.CV_8UC3);
        Core.randu(r, 0, 255);
        printMat(r);


        Point p =new Point(6,5);
        MatOfPoint2f point2f = new MatOfPoint2f(p);
        System.out.println(point2f.dump());

        MatOfPoint3f point3f = new MatOfPoint3f(new Point3(5,6,8));
        System.out.println(point3f.dump());


        Mat mat = new Mat();

    }
    public static void printMat(Mat mat){
       /* for (int i=0;i<mat.rows();i++){
            for (int j = 0; j < mat.cols(); j++) {
                double temp[] = mat.get(i,j);
                System.out.print(temp[0] + " , ");
               // System.out.println();
            }
            System.out.println();
        }*/

        System.out.println(mat.dump());
        System.out.println(mat.dataAddr());
    }
}
