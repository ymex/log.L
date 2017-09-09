# cute.L
Log printer for Android


## Use in Android Studio

```
    compile 'cn.ymex:cute.L:1.0.0'
```

## Sample Usage


```
L.w("this is String type!");
L.d(Data.object());
L.e(Data.array());
...
```
[Refer to the sample](https://github.com/ymex/cute.L/blob/master/app%2Fsrc%2Fmain%2Fjava%2Fcn%2Fymex%2Fcutel%2FMainActivity.java)


## Question
### what is Log default TAG？
```
 public static String TAG = "cute.L";//default tag
```

### how to set tag ?

```
L.d(tag,message);
```

### why my Android studio Logcat has no color ?
you need set android studio color in：
`File > Settings > Editor > Colors &Fonts -> Android Logcat`
check off `Use Inberited attributes`，  then check `Foreground` ，check `Foreground`，
click `Foreground` color selecter。

Demo color:
<table>
    <tr>
        <th>Tag</th>
        <th>Value</th>
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


### Log print format disorder ？
setting Android studio  Console font size。
`Editor>Colors&Fonts>Console Font `

### close log printer？

```
L.setLOG(false);
```

### Custom log print format ？
you need extend `Printer` and implement the following method：
```
    public abstract String logHeader();//log header
    public abstract String logFooter();//log footer
    public abstract String logContent(Object message);//log content
```
set `L.setPrinter(new CustomerPrinter());`。

### Want a simple print format？
```
L.setPrinter(new SimplePrinter());
```

## capture picture

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
