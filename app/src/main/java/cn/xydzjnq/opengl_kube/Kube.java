package cn.xydzjnq.opengl_kube;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kube {
    private Cube[] mCubes = new Cube[27];

    float c0 = -1.0f;
    float c1 = -0.38f;
    float c2 = -0.31f;
    float c3 = 0.31f;
    float c4 = 0.38f;
    float c5 = 1.0f;

    public Kube(Context context) {
        // top back, left to right
        mCubes[0] = new Cube(context, c0, c4, c0, c1, c5, c1);
        mCubes[1] = new Cube(context, c2, c4, c0, c3, c5, c1);
        mCubes[2] = new Cube(context, c4, c4, c0, c5, c5, c1);
        // top middle, left to right
        mCubes[3] = new Cube(context, c0, c4, c2, c1, c5, c3);
        mCubes[4] = new Cube(context, c2, c4, c2, c3, c5, c3);
        mCubes[5] = new Cube(context, c4, c4, c2, c5, c5, c3);
        // top front, left to right
        mCubes[6] = new Cube(context, c0, c4, c4, c1, c5, c5);
        mCubes[7] = new Cube(context, c2, c4, c4, c3, c5, c5);
        mCubes[8] = new Cube(context, c4, c4, c4, c5, c5, c5);
        // middle back, left to right
        mCubes[9] = new Cube(context, c0, c2, c0, c1, c3, c1);
        mCubes[10] = new Cube(context, c2, c2, c0, c3, c3, c1);
        mCubes[11] = new Cube(context, c4, c2, c0, c5, c3, c1);
        // middle middle, left to right
        mCubes[12] = new Cube(context, c0, c2, c2, c1, c3, c3);
        mCubes[13] = null;
        mCubes[14] = new Cube(context, c4, c2, c2, c5, c3, c3);
        // middle front, left to right
        mCubes[15] = new Cube(context, c0, c2, c4, c1, c3, c5);
        mCubes[16] = new Cube(context, c2, c2, c4, c3, c3, c5);
        mCubes[17] = new Cube(context, c4, c2, c4, c5, c3, c5);
        // bottom back, left to right
        mCubes[18] = new Cube(context, c0, c0, c0, c1, c1, c1);
        mCubes[19] = new Cube(context, c2, c0, c0, c3, c1, c1);
        mCubes[20] = new Cube(context, c4, c0, c0, c5, c1, c1);
        // bottom middle, left to right
        mCubes[21] = new Cube(context, c0, c0, c2, c1, c1, c3);
        mCubes[22] = new Cube(context, c2, c0, c2, c3, c1, c3);
        mCubes[23] = new Cube(context, c4, c0, c2, c5, c1, c3);
        // bottom front, left to right
        mCubes[24] = new Cube(context, c0, c0, c4, c1, c1, c5);
        mCubes[25] = new Cube(context, c2, c0, c4, c3, c1, c5);
        mCubes[26] = new Cube(context, c4, c0, c4, c5, c1, c5);
    }

    public void draw(float[] mvpMatrix) {
        for (Cube cube : mCubes) {
            if (cube != null) {
                cube.draw(mvpMatrix);
            }
        }
    }
}
