package cn.xydzjnq.opengl_kube;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kube {
    private Cube[] mCubes = new Cube[27];
    public Layer[] layers = new Layer[9];

    float c0 = -1.0f;
    float c1 = -0.38f;
    float c2 = -0.31f;
    float c3 = 0.31f;
    float c4 = 0.38f;
    float c5 = 1.0f;

    public Kube(Context context) {
        // top front, left to right
        mCubes[0] = new Cube(c0, c4, c4, c1, c5, c5);
        mCubes[1] = new Cube(c2, c4, c4, c3, c5, c5);
        mCubes[2] = new Cube(c4, c4, c4, c5, c5, c5);
        // top middle, left to right
        mCubes[3] = new Cube(c0, c4, c2, c1, c5, c3);
        mCubes[4] = new Cube(c2, c4, c2, c3, c5, c3);
        mCubes[5] = new Cube(c4, c4, c2, c5, c5, c3);
        // top back, left to right
        mCubes[6] = new Cube(c0, c4, c0, c1, c5, c1);
        mCubes[7] = new Cube(c2, c4, c0, c3, c5, c1);
        mCubes[8] = new Cube(c4, c4, c0, c5, c5, c1);
        // middle front, left to right
        mCubes[9] = new Cube(c0, c2, c4, c1, c3, c5);
        mCubes[10] = new Cube(c2, c2, c4, c3, c3, c5);
        mCubes[11] = new Cube(c4, c2, c4, c5, c3, c5);
        // middle middle, left to right
        mCubes[12] = new Cube(c0, c2, c2, c1, c3, c3);
        mCubes[13] = null;
        mCubes[14] = new Cube(c4, c2, c2, c5, c3, c3);
        // middle back, left to right
        mCubes[15] = new Cube(c0, c2, c0, c1, c3, c1);
        mCubes[16] = new Cube(c2, c2, c0, c3, c3, c1);
        mCubes[17] = new Cube(c4, c2, c0, c5, c3, c1);
        // bottom front, left to right
        mCubes[18] = new Cube(c0, c0, c4, c1, c1, c5);
        mCubes[19] = new Cube(c2, c0, c4, c3, c1, c5);
        mCubes[20] = new Cube(c4, c0, c4, c5, c1, c5);
        // bottom middle, left to right
        mCubes[21] = new Cube(c0, c0, c2, c1, c1, c3);
        mCubes[22] = new Cube(c2, c0, c2, c3, c1, c3);
        mCubes[23] = new Cube(c4, c0, c2, c5, c1, c3);
        // bottom back, left to right
        mCubes[24] = new Cube(c0, c0, c0, c1, c1, c1);
        mCubes[25] = new Cube(c2, c0, c0, c3, c1, c1);
        mCubes[26] = new Cube(c4, c0, c0, c5, c1, c1);
        layers[0] = new Layer(Layer.sAxisY);
        layers[1] = new Layer(Layer.sAxisY);
        layers[2] = new Layer(Layer.sAxisY);
        layers[3] = new Layer(Layer.sAxisZ);
        layers[4] = new Layer(Layer.sAxisZ);
        layers[5] = new Layer(Layer.sAxisZ);
        layers[6] = new Layer(Layer.sAxisX);
        layers[7] = new Layer(Layer.sAxisX);
        layers[8] = new Layer(Layer.sAxisX);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                layers[0].getCubes()[i * 3 + j] = mCubes[i * 3 + j];
                layers[1].getCubes()[i * 3 + j] = mCubes[i * 3 + j + 9];
                layers[2].getCubes()[i * 3 + j] = mCubes[i * 3 + j + 18];
                layers[3].getCubes()[i * 3 + j] = mCubes[i * 9 + j];
                layers[4].getCubes()[i * 3 + j] = mCubes[i * 9 + j + 3];
                layers[5].getCubes()[i * 3 + j] = mCubes[i * 9 + j + 6];
                layers[6].getCubes()[i * 3 + j] = mCubes[i * 9 + j * 3];
                layers[7].getCubes()[i * 3 + j] = mCubes[i * 9 + j * 3 + 1];
                layers[8].getCubes()[i * 3 + j] = mCubes[i * 9 + j * 3 + 2];
            }
        }
        for (int i = 0; i < 27; i++) {
            if (mCubes[i] != null) {
                mCubes[i].setData(context, this);
            }
        }
    }

    public void draw(float[] mvpMatrix) {
        for (Cube cube : mCubes) {
            if (cube != null) {
                cube.draw(mvpMatrix);
            }
        }
    }
}
