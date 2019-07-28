package cn.wqgallery.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import cn.wqgallery.commonlib.MyService;

@Route(path = "/home/main")
public class MainActivity extends AppCompatActivity {

    @Autowired
    boolean isLogin;
    @Autowired
    String password;


    @Autowired
    MyService myService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        ARouter.getInstance().inject(this);

        if (isLogin) {
            Toast.makeText(this, "find模块的密码" + password, Toast.LENGTH_SHORT).show();
        }
    }


    public void send(View view) {
        ARouter.getInstance()
                .build("/app/main")
                .withString("content", "来自home模块数据")
                .navigation();

    }


    /**
     * 调用fined接口实现类的方法
     */
    public void sendService(View view) {
        String add = myService.add(10, 15);
        Toast.makeText(this, "" + add, Toast.LENGTH_SHORT).show();
    }
}
