package cn.yy.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class f {
    public static void main(String[] args) {
        try {
//            int a=2/0;
            float f=1.0f;
            byte b=(byte)156;
            System.out.println(b);
            double d=2.5;
            long l=3;
            System.out.println("try");
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
    }
}

