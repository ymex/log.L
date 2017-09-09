/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 * Email:ymex@foxmail.com  (www.ymex.cn)
 *
 * @author ymex
 */
package cn.ymex.log;

import android.util.Log;


public final class L {

    /**
     * 不允许实例化
     */
    private L() {
        throw new RuntimeException("Class L Not allow instance!");
    }

    private L(String tag) {
        this.mTag = tag;
    }

    private static Printer printer;
    private static boolean LOG;
    private static String dividers;

    private String mTag = Printer.TAG;


    static {
        printer = new LPrinter();
        LOG = true;
        dividers = Printer.DIVIDERS;
    }

    /**
     * 全局
     * 设置自定义 printer
     *
     * @param p
     */
    public static void setPrinter(Printer p) {
        printer = p;
    }

    /**
     * 全局
     * 设置日志是否打印
     *
     * @param flag
     */
    public static void printLOG(boolean flag) {
        LOG = flag;
    }


    public static L tag(String tag) {
        return new L(tag);
    }

    public static L tag() {
        return new L(Printer.TAG);
    }

    //<editor-fold desc="Log.VERBOSE">
    public L logV(Object... message) {
        f(Log.VERBOSE, this.mTag, message);
        return this;
    }

    public static void v(Object message) {
        fo(Log.VERBOSE, Printer.TAG, message);
    }

    public static void v(String tag, Object message) {
        fo(Log.VERBOSE, tag, message);
    }
    //</editor-fold>


    //<editor-fold desc="Log.INFO">
    public L logI(Object... message) {
        f(Log.INFO, this.mTag, message);
        return this;
    }

    public static void i(Object message) {
        fo(Log.INFO, Printer.TAG, message);
    }

    public static void i(String tag, Object message) {
        fo(Log.INFO, tag, message);
    }

    //</editor-fold>


    //<editor-fold desc="Log.DEBUG">

    /**
     * 多参数
     *
     * @param message
     * @return
     */
    public L logD(Object... message) {
        f(Log.DEBUG, this.mTag, message);
        return this;
    }

    public static void d(Object message) {
        fo(Log.DEBUG, Printer.TAG, message);
    }

    public static void d(String tag, Object message) {
        fo(Log.DEBUG, tag, message);
    }


    //</editor-fold>


    //<editor-fold desc="Log.WARN">
    public L logW(Object... message) {
        f(Log.WARN, this.mTag, message);
        return this;
    }

    public static void w(Object message) {
        fo(Log.WARN, Printer.TAG, message);
    }

    public static void w(String tag, Object message) {
        fo(Log.WARN, tag, message);
    }
    //</editor-fold>


    //<editor-fold desc="Log.ERROR">
    public L logE(Object... messages) {
        fo(Log.ERROR, this.mTag, messages);
        return this;
    }

    public static void e(Object message) {
        fo(Log.ERROR, Printer.TAG, message);
    }

    public static void e(String tag, Object message) {
        fo(Log.ERROR, tag, message);
    }
    //</editor-fold>

    private static void fo(int level, String tag, Object message) {
        if (!LOG) {
            return;
        }
        printer.log(level, tag, message);
    }

    private static void f(int level, String tag, Object... messages) {
        if (!LOG) {
            return;
        }
        if (messages == null) {
            printer.log(level, tag, messages);
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Object message : messages) {
            builder.append(printer.logContent(message).trim());
            builder.append(dividers);
        }
        printer.log(level, tag, builder.toString().trim());
        return;
    }

    /**
     * 获得日志内容
     *
     * @param message
     */
    public static String getLog(Object message) {
        return printer.logContent(message);
    }

    /**
     * 强制转为Object对象,用于处理 object可变参所带来的问题 ,(只有当参数是数组时才可能 遇到这样的问题。)
     *
     * @param message
     * @return
     */
    public static Object o(Object message) {
        return (Object) message;
    }

    public static void setDividers(String divider) {
        dividers = divider;
    }
}
