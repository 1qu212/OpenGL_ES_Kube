package cn.xydzjnq.opengl_kube;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kube {
    private List<Cube> cubeList = new ArrayList<>();

    float c0 = -1.0f;
    float c1 = -0.38f;
    float c2 = -0.31f;
    float c3 = 0.31f;
    float c4 = 0.38f;
    float c5 = 1.0f;

    public Kube(Context context) {
        // top back, left to right
        cubeList.add(new Cube(context, c0, c4, c0, c1, c5, c1));
        cubeList.add(new Cube(context, c2, c4, c0, c3, c5, c1));
        cubeList.add(new Cube(context, c4, c4, c0, c5, c5, c1));
        // top middle, left to right
        cubeList.add(new Cube(context, c0, c4, c2, c1, c5, c3));
        cubeList.add(new Cube(context, c2, c4, c2, c3, c5, c3));
        cubeList.add(new Cube(context, c4, c4, c2, c5, c5, c3));
        // top front, left to right
        cubeList.add(new Cube(context, c0, c4, c4, c1, c5, c5));
        cubeList.add(new Cube(context, c2, c4, c4, c3, c5, c5));
        cubeList.add(new Cube(context, c4, c4, c4, c5, c5, c5));
        // middle back, left to right
        cubeList.add(new Cube(context, c0, c2, c0, c1, c3, c1));
        cubeList.add(new Cube(context, c2, c2, c0, c3, c3, c1));
        cubeList.add(new Cube(context, c4, c2, c0, c5, c3, c1));
        // middle middle, left to right
        cubeList.add(new Cube(context, c0, c2, c2, c1, c3, c3));

        cubeList.add(new Cube(context, c4, c2, c2, c5, c3, c3));
        // middle front, left to right
        cubeList.add(new Cube(context, c0, c2, c4, c1, c3, c5));
        cubeList.add(new Cube(context, c2, c2, c4, c3, c3, c5));
        cubeList.add(new Cube(context, c4, c2, c4, c5, c3, c5));
        // bottom back, left to right
        cubeList.add(new Cube(context, c0, c0, c0, c1, c1, c1));
        cubeList.add(new Cube(context, c2, c0, c0, c3, c1, c1));
        cubeList.add(new Cube(context, c4, c0, c0, c5, c1, c1));
        // bottom middle, left to right
        cubeList.add(new Cube(context, c0, c0, c2, c1, c1, c3));
        cubeList.add(new Cube(context, c2, c0, c2, c3, c1, c3));
        cubeList.add(new Cube(context, c4, c0, c2, c5, c1, c3));
        // bottom front, left to right
        cubeList.add(new Cube(context, c0, c0, c4, c1, c1, c5));
        cubeList.add(new Cube(context, c2, c0, c4, c3, c1, c5));
        cubeList.add(new Cube(context, c4, c0, c4, c5, c1, c5));
    }

    public void draw(float[] mvpMatrix) {
        for (Cube cube : cubeList) {
            cube.draw(mvpMatrix);
        }
    }
}
