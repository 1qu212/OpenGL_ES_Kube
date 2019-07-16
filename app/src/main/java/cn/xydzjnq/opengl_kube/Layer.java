package cn.xydzjnq.opengl_kube;

import java.util.List;

public class Layer {
    private int mAxis;
    private Cube[] mCubes = new Cube[9];
    public static final int sAxisX = 0;
    public static final int sAxisY = 1;
    public static final int sAxisZ = 2;

    public Layer(int axis) {
        mAxis = axis;
    }

    public int getmAxis() {
        return mAxis;
    }

    public Cube[] getmCubes() {
        return mCubes;
    }
}
