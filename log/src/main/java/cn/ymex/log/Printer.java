/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 * Email:ymex@foxmail.com  (www.ymex.cn)
 *
 * @author ymex  15/03/29
 */
package cn.ymex.log;

import android.util.Log;

import java.lang.reflect.Method;


public abstract class Printer {
    public static final int ENV_STACK = 7;
    public static final int JSON_INDENT = 4;
    public static final int MAX_CHARS= (int)(3.9*1024);//4*1024
    public static final String TAG = "log.L";//默认日志tag

    public static final String NEXT_LINE = "\n";
    public static final String TAB = "\t";
    //打印多参时log 间的分割
    public static final String DIVIDERS=NEXT_LINE+NEXT_LINE;

    /**
     * 日志头部内容
     *
     * @return
     */
    public abstract String logHeader();

    /**
     * 日志底部内容
     *
     * @return
     */
    public abstract String logFooter();

    /**
     * 日志内容
     *
     * @return
     */
    public abstract String logContent(Object message);


    /**
     * 打印日志
     *
     * @param leve    级别android.utils.LOG 中的级别
     * @param tag
     * @param message
     */
    public void log(int leve, String tag, Object message) {

        StringBuilder builder = new StringBuilder(logHeader());
        builder.append(NEXT_LINE);
        builder.append(logContent(message));
        builder.append(NEXT_LINE);
        builder.append(logFooter());
        builder.append(NEXT_LINE);

        int logLength = builder.toString().length();

        if (logLength > MAX_CHARS) {
            _log(leve,tag,logHeader().toString());
            String logContent = logContent(message);
            int len = logContent.length();
            int count = len/MAX_CHARS+(len%MAX_CHARS==0?0:1);
            for (int i = 1; i<= count; i++){
                int start = (i-1)*MAX_CHARS;
                int end = start+MAX_CHARS;
                if (i==count){
                    _log(leve, tag, logContent.substring(start, len));
                }else {
                    _log(leve, tag, logContent.substring(start, end));
                }

            }
            _log(leve,tag,logFooter().toString());
            return;
        }
        _log(leve, tag, builder.toString());
    }

    private void _log(int leve, String tag, String log) {

        tag = generateTag(tag);
        switch (leve) {
            case Log.INFO:
                Log.i(tag, log);
                break;
            case Log.DEBUG:
                Log.d(tag, log);
                break;
            case Log.ERROR:
                Log.e(tag, log);
                break;
            case Log.WARN:
                Log.w(tag, log);
                break;
            case Log.VERBOSE:
                Log.v(tag, log);
                break;
        }
    }


    /**
     * 生成用户配置标签：D/Tag/MainActivity
     *
     * @param tag
     * @return
     */
    public String generateTag(String tag) {
        if (tag.length() <= 0 || tag == null) {
            tag = TAG;
        }
        StringBuilder builder = new StringBuilder();
        String name = getLayerStackTrace(ENV_STACK+1).getClassName();
        int lastIndex = name.lastIndexOf(".");
        name = name.substring(lastIndex + 1);
        int i = name.indexOf("$");
        builder.append(i == -1 ? name : name.substring(0, i)).toString();
        builder.append("/" + tag);
        return builder.toString();
    }

    public StackTraceElement[] getStackTrace() {
        return Thread.currentThread().getStackTrace();
    }

    public StackTraceElement getLayerStackTrace(int layer) {
        return Thread.currentThread().getStackTrace()[layer];
    }

    /**
     * 生成方法详情
     *
     * @param method
     * @return
     */
    public String methodDetail(Method method) {
        Class typeCls[] = method.getParameterTypes();
        StringBuilder builder = new StringBuilder();
        for (Class clazz : typeCls) {
            builder.append(", ");
            builder.append(clazz.getSimpleName());
        }
        return method.getReturnType().getSimpleName() + " " + method.getName() + "(" + (builder.length() >= 2 ? builder.substring(2) : builder.toString()) + ")";
    }

    /**
     * 判断一个对象是否是数组
     *
     * @param object
     * @return
     */
    public boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    /**
     * 判断数组的维度
     *
     * @param object
     * @return
     */
    public int dimensionCount(Object object) {
        return object.getClass().getName().split("\\[").length - 1;
    }

    /**
     * 生成带链接的日志信息
     *
     * @param element
     * @return
     */
    public String generateLinkMessage(StackTraceElement element) {
        StringBuilder builder = new StringBuilder();
        builder.append(element.getClassName());
        builder.append(" / ");
        builder.append("(");
        builder.append(element.getFileName());
        builder.append(":");
        builder.append(element.getLineNumber());
        builder.append(")");
        return builder.toString();
    }
}
