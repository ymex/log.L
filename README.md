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
- 日志没有颜色
你需要在android studio 设置颜色：
File->Settings 或Ctrl + Alt +S 找到 Editor -> Colors &Fonts -> Android Logcat
去掉Use Inberited attributes的勾选框，  再将 Foreground 前的复选框选上，勾选Foreground选择框，点击Foreground后面颜色选择框。就可以选颜色了。 选好颜色点击Apply–>OK就能保存到android studio 中。

样例配色:
|标签|色值|
| :---- |  :---: |
|Verbose |\#F9BDBB|
|Info    |\#B39DDB|
|Debug   |\#738FFE|
|warning |\#EF6C00|
|Error   |\#E00032|
|Assert  |\#FF1696|
<table border="1">
  <tr>
    <th>Month</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td>January</td>
    <td>$100</td>
  </tr>
</table>
- 日志打印格式错乱
设置你Android studio 的字体大小。


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
