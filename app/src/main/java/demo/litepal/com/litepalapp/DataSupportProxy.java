package demo.litepal.com.litepalapp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2015/4/27 0027.
 */
public class DataSupportProxy implements InvocationHandler {
    public interface OnContentChangedNotify{
        public void notifyDataChanged();
    }
    private OnContentChangedNotify mOnContentChangedNotify;
    private Object mTargetObject;
    public Object build(Object target) {
        this.mTargetObject = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
    public Object build(Object target,OnContentChangedNotify mOnContentChangedNotify) {
        this.mOnContentChangedNotify = mOnContentChangedNotify;
        return this.build(target);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(mTargetObject,args);
        if(mOnContentChangedNotify!=null){
            mOnContentChangedNotify.notifyDataChanged();
        }
        return result;
    }
}
