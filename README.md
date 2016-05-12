# cute.L
Log printer for Android

##Use in Android Studio

```
dependencies {
    compile 'cn.ymex:cute.L:0.5.2'
}
```

##Sample Usage


```java
 @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base://base type
                L.i(1);
                L.d(2.0);
                L.e(false);
                L.w("this is String type!");
                break;
            case R.id.btn_ob://object type
                L.d(Data.object());
                break;
            case R.id.btn_null:// object is null
                L.d(null);
                break;
            case R.id.btn_list: // list type
                L.d(Data.list());
                break;
            case R.id.btn_map://map type
                L.w(Data.map());
                break;
            case R.id.btn_array://array type
                L.e(Data.array());
                break;
            case R.id.btn_json://json data
                L.i(new Gson().toJson(Data.array()));
                break;
        }
    }
```
##问题
###日志没有颜色
你需要在android studio 设置颜色：
File->Settings 或Ctrl + Alt +S 找到 Editor -> Colors &Fonts -> Android Logcat
去掉Use Inberited attributes的勾选框，  再将 Foreground 前的复选框选上，勾选Foreground选择框，点击Foreground后面颜色选择框。就可以选颜色了。 选好颜色点击Apply–>OK就能保存到android studio 中。

样例配色:
<table border="1" width="auto">
    <tr>
        <th>标签</th>
        <th>色值</th>
    </tr>
    <tr>
        <td>Verbose</td>
        <td bgcolor=">#F9BDBB">#F9BDBB</td>
    </tr>
    <tr>
        <td>Info</td>
        <td bgcolor="#B39DDB">#B39DDB</td>
    </tr>
    <tr>
        <td>Debug</td>
        <td bgcolor="#738FFE">#738FFE</td>
    </tr>
    <tr>
        <td>warning</td>
        <td bgcolor="#EF6C00">#EF6C00</td>
    </tr>
    <tr>
        <td>Error</td>
        <td bgcolor="#E00032">#E00032</td>
    </tr>
    <tr>
        <td>Assert</td>
        <td bgcolor="#FF1696">#FF1696</td>
    </tr>
</table>


###日志打印格式错乱？
设置你Android studio 的字体大小。

###全局关闭日志打印？

```
L.setLOG(false);
```

###自定义打印格式？
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
