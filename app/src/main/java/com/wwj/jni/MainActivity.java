package com.wwj.jni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        //lib+native-lib+so
        //libnative-lib.so
        System.loadLibrary("hellojni");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

//        tv.setText(stringFromJNI()+"-----"+add(5,13));


        StringBuilder stringBuilder=new StringBuilder();


        int result=add(23,35);//58
        stringBuilder.append("add(23,35)="+result+"-----");

        short s1=923,s2=789;//134
        short sresult=sub(s1,s2);
        stringBuilder.append("sub(923,789)="+sresult+"\r\n");

        double dres=multi(30,20.2); //606.6
        stringBuilder.append("multi(30,20.2)="+dres+"----");

        long lres=divi(180,30); //6
        stringBuilder.append("divi(180,30)="+lres+"\r\n");

        char ch=getChar('A');
        stringBuilder.append("etChar('A')="+ch+"-----");

        byte bres=sqrt((byte) 25);
        stringBuilder.append("sqrt(25)="+bres+"\r\n");

        float fres=power(2,5);
        stringBuilder.append("power(2,5)="+fres+"-----");

        boolean bool=isTrue(true);
        stringBuilder.append("isTrue(true)="+bool+"\r\n");

        tv.setText(stringBuilder.toString());

    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(); //声明一个原声函数

    public native int add(int a, int b);
    public native short sub(short a,short b);
    public native double multi(double a,double b);
    public native long divi(long a,long b);
    public native char getChar(char a);
    public native byte sqrt(byte a);
    public native float power(float num,float b);
    public native boolean isTrue(boolean b);


    // byte类型字节数=1
// boolean类型字节数=1
// char类型字节数=2
// short类型字节数=2
// int类型字节数=4
// long类型字节数=8
// float类型字节数=4
// double类型字节数=8





}
