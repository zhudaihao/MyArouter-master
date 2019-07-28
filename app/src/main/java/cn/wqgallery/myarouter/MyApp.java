package cn.wqgallery.myarouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApp extends Application {

    private boolean debug = true;//测试版设置true，线上版设置false

    public boolean isDebug() {
        return debug;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化ARouter
        initARouter();
    }

    private void initARouter() {
        //这两行必须在init之前
        if (isDebug()) {
            ARouter.openLog();//打印日子
            ARouter.openDebug();//开启调试模式线上版本关闭
        }

        ARouter.init(this);


    }
}
