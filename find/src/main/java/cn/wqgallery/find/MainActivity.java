package cn.wqgallery.find;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 1 注解path需要两级目录
 */
@Route(path = "/find/main")
public class MainActivity extends AppCompatActivity {

    //2定义接受数据（变量名字必须和发送的一致，类型也一致;变量不能被private修饰）
    @Autowired
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_main);
        //3注入
        ARouter.getInstance().inject(this);

        Toast.makeText(this, "" + name, Toast.LENGTH_SHORT).show();

    }


    //跳转到home模块
    public void send(View view) {
        ARouter.getInstance()
                .build("/home/main")
                .withBoolean("isLogin", true)
                .withString("password", "123")
                .navigation();

    }


}
