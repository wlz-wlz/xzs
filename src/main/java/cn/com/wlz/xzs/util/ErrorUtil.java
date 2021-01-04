package cn.com.wlz.xzs.util;

public class ErrorUtil {
    public static String parameterErrorFormat(String field, String msg) {
        return "[" + field + " : " + msg + "]";
    }
}
