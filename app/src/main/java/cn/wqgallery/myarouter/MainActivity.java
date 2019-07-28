package cn.wqgallery.myarouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 1 注解path需要两级目录
 */
@Route(path = "/app/main")
public class MainActivity extends AppCompatActivity {
    @Autowired
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        //2 在需要的地方注入可以封装在base里面
        ARouter.getInstance().inject(this);

        if (!TextUtils.isEmpty(content))
            Toast.makeText(this, "" + content, Toast.LENGTH_SHORT).show();

    }

    //跳转到find模块
    public void send(View view) {
        //3 跳转模块 build模式 可以带参数传递，参数key必须和接受的定义类型名字一致
        ARouter.getInstance()
                .build("/find/main")  //设置跳转的目标 path就是目标类注解写的path
                .withString("name", "来自APP的信息") //传递数据 key和接受的类定义的变量名字和类型一致
                .navigation();//执行




    }
}
