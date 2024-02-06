package cn.whlit.maven.ejml;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

/**
 * @author WangHaiLong 2024/2/6 19:24
 */
public class Main {
    public static void main(String[] args) {
        double[][] aArray = new double[][]{
                {1, 1},
                {1, 2}
        };
        DMatrixRMaj a = new DMatrixRMaj(aArray);
        DMatrixRMaj b = new DMatrixRMaj(2, 2);
        boolean invert = CommonOps_DDRM.invert(a, b);
        System.out.println(invert);
    }
}
