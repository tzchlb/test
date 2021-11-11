package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }

    //代理类的业务方法
    //动态代理的两个作用：1、控制访问；2、增强功能，在不改变目标方法功能的基础上，增加自己所需要增强的功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try{
            sqlSession = SqlSessionUtil.getSession();
            obj = method.invoke(target,args);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }

    //创建代理类对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
