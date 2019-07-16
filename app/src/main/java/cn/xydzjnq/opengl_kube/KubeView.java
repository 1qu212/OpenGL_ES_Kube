package cn.xydzjnq.opengl_kube;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class KubeView extends GLSurfaceView {
    private KubeRenderer mRenderer;

    public KubeView(Context context) {
        this(context, null);
    }

    public KubeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setEGLContextClientVersion(2);
        mRenderer = new KubeRenderer(context);
        setRenderer(mRenderer);
    }

    public class KubeRenderer implements GLSurfaceView.Renderer {
        private Kube mKube;
        private Context mContext;

        private final float[] vPMatrix = new float[16];
        private final float[] projectionMatrix = new float[16];
        private final float[] viewMatrix = new float[16];
        private final float[] modelMatrix = new float[16];

        public KubeRenderer(Context context) {
            mContext = context;
        }

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
            mKube = new Kube(mContext);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
            float ratio = (float) width / height;
            // this projection matrix is applied to object coordinates
            // in the onDrawFrame() method
            Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1, 1, 2, 12);
            GLES20.glDisable(GL10.GL_DITHER);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1);
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
            Matrix.setLookAtM(viewMatrix, 0, 0, 0, 3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
            Matrix.setIdentityM(modelMatrix, 0);
            Matrix.scaleM(modelMatrix, 0, 0.5f, 0.5f, 0.5f);
            Matrix.rotateM(modelMatrix, 0, 30.0f, 0, 1, 0);
            Matrix.rotateM(modelMatrix, 0, 7.5f, 1, 0, 0);
            Matrix.multiplyMM(vPMatrix, 0, viewMatrix, 0, modelMatrix, 0);
            Matrix.multiplyMM(vPMatrix, 0, projectionMatrix, 0, vPMatrix, 0);
            GLES20.glEnable(GLES20.GL_CULL_FACE);
            GLES20.glEnable(GLES20.GL_DEPTH_TEST);
            mKube.draw(vPMatrix);
        }
    }
}
