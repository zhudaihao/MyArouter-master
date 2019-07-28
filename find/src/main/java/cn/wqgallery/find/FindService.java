package cn.wqgallery.find;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.wqgallery.commonlib.MyService;

@Route(path = "/find/findService", name = "测试服务")
public class FindService implements MyService {
    @Override
    public String add(int a, int b) {
        return String.valueOf(a + b);
    }

    @Override
    public void init(Context context) {
    }
}
