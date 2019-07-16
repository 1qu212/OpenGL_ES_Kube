package cn.xydzjnq.opengl_kube;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Cube {
    private List<GLFace> glFaceList = new ArrayList<>();

    float[] red = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
    float[] green = new float[]{0.0f, 1.0f, 0.0f, 1.0f};
    float[] blue = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
    float[] yellow = new float[]{1.0f, 1.0f, 0.0f, 1.0f};
    float[] orange = new float[]{1.0f, 0.5f, 0.0f, 1.0f};
    float[] white = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    float[] black = new float[]{0.0f, 0.0f, 0.0f, 1.0f};

    public Cube(Context context, float left, float bottom, float back, float right, float top, float front) {
        GLVertex leftBottomBack = new GLVertex(left, bottom, back);
        GLVertex rightBottomBack = new GLVertex(right, bottom, back);
        GLVertex leftTopBack = new GLVertex(left, top, back);
        GLVertex rightTopBack = new GLVertex(right, top, back);
        GLVertex leftBottomFront = new GLVertex(left, bottom, front);
        GLVertex rightBottomFront = new GLVertex(right, bottom, front);
        GLVertex leftTopFront = new GLVertex(left, top, front);
        GLVertex rightTopFront = new GLVertex(right, top, front);
        //front
        glFaceList.add(new GLFace(context, leftTopFront, leftBottomFront, rightBottomFront, rightTopFront, green));
        //left
        glFaceList.add(new GLFace(context, leftTopBack, leftBottomBack, leftBottomFront, leftTopFront, yellow));
        //top
        glFaceList.add(new GLFace(context, rightTopBack, leftTopBack, leftTopFront, rightTopFront, orange));
        //back
        glFaceList.add(new GLFace(context, rightBottomBack, leftBottomBack, leftTopBack, rightTopBack, blue));
        //right
        glFaceList.add(new GLFace(context, rightBottomFront, rightBottomBack, rightTopBack, rightTopFront, white));
        //bottom
        glFaceList.add(new GLFace(context, leftBottomFront, leftBottomBack, rightBottomBack, rightBottomFront, red));
    }

    public void draw(float[] mvpMatrix) {
        for (GLFace glFace : glFaceList) {
            glFace.draw(mvpMatrix);
        }
    }
}