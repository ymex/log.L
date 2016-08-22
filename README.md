# cute.L
Log printer for Android


##Use in Android Studio

```
    compile 'cn.ymex:cute.L:1.0.0'
```

##Sample Usage


```java
    L.w("this is String type!");
    L.d(Data.object());
    L.e(Data.array());
    ...
```
具体[参考样例](https://github.com/ymex/cute.L/blob/master/app%2Fsrc%2Fmain%2Fjava%2Fcn%2Fymex%2Fcutel%2FMainActivity.java)


##Question
###日志默认TAG是什么？
```
 public static String TAG = "cute.L";//默认日志tag
```

###如何设置tag ?

```
L.d(tag,message);
```

###日志没有颜色 ?
你需要在android studio 设置颜色：
`File > Settings > Editor > Colors &Fonts -> Android Logcat`
去掉`Use Inberited attributes`的勾选框，  再将 `Foreground` 前的复选框选上，勾选`Foreground选择框`，
点击`Foreground`后面颜色选择框。就可以选颜色了。 选好颜色点击`Apply–>OK`就能保存到android studio 中。

样例配色:
<table>
    <tr>
        <th>标签</th>
        <th>色值</th>
    </tr>
    <tr>
        <td>Verbose</td>
        <td>#F9BDBB</td>
    </tr>
    <tr>
        <td>Info</td>
        <td>#B39DDB</td>
    </tr>
    <tr>
        <td>Debug</td>
        <td>#738FFE</td>
    </tr>
    <tr>
        <td>warning</td>
        <td>#EF6C00</td>
    </tr>
    <tr>
        <td>Error</td>
        <td>#E00032</td>
    </tr>
    <tr>
        <td>Assert</td>
        <td>#FF1696</td>
    </tr>
</table>


###日志打印格式错乱 ？
设置Android studio  Console 字体大小。
`Editor>Colors&Fonts>Console Font `

###全局关闭日志打印？

```
L.setLOG(false);
```

###自定义打印格式 ？
你只需要要继承 `Printer` 类 实现以下方法：
```
    public abstract String logHeader();//日志头部
    public abstract String logFooter();//日志底部内容
    public abstract String logContent(Object message);//日志内容
```
设置`L.setPrinter(new CustomerPrinter());`即可。



##capture picture

- Base type

<img src="https://github.com/ymex/cute.L/blob/master/base.png" width="100%" />

- Object type

<img src="https://github.com/ymex/cute.L/blob/master/object.png" width="100%" />

- List type

<img src="https://github.com/ymex/cute.L/blob/master/list.png" width="100%" />

- Map type

<img src="https://github.com/ymex/cute.L/blob/master/map.png" width="100%" />

- Array type

<img src="https://github.com/ymex/cute.L/blob/master/array.png" width="100%" />
