package com.gugu;

public class Test {
    public static void main(String[] args) {
//        0b10000001, 0b10000010, 0b10000011, 0b00000100
        byte[] bs = {
            (byte) 0b10010110,
            (byte) 0b00000001
        };

        System.out.println(readVarLong(bs));
//        System.out.println(readVarLong2(bs));
    }

    public static long readLong(byte[] bytes) {
        long result = 0;

        long wz = 1; // 位置代表的值
        for (int i = 0; i < bytes.length; i++) {
            // 前面的是位置大，从后向前计算
            result += bytes[bytes.length - i - 1] * wz;
            wz *= 256;
        }

        return result;
    }

    public static long readVarLong(byte[] bytes) {
        long result = 0;

        long wz = 1; // 位置代表的值
        for (int i = 0; i < bytes.length; i++) {
            result += (bytes[i] & (byte) 0b01111111) * wz;
            wz *= 128;
            if ((bytes[i] & (byte) 0b10000000) == 0b00000000 ){
                    break;
            }
        }
        return result;
    }


}
