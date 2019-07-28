package cn.wqgallery.commonlib;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 定义个接口 各个模块集成这个模块就可以调用这个接口/或者实现接口方法
 */

public interface MyService extends IProvider {

    String add(int a, int b);
}
