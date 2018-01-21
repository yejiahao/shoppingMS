/*Copyright ©  2018 Lyons. All rights reserved. */
package lyons.common.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 获取当前时间
 * @ClassName: TimeUtil
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 上午10:29:30
 * @version: [1.0]
 */
public class TimeUtil {
    private TimeUtil() {
        throw new AssertionError();
    }

    /**
     * @Title: getYMD
     * @Description: 获取当前时间（年-月-日）
     * @return: Date
     */
    public static Date getYMD() {
        return new Date();
    }

    /**
     * @return
     * @Title: getYMDHMS
     * @Description: 获取当前时间（年-月-日 时:分:秒）
     * @return: Date
     */
    public static Date getYMDHMS() {
        SimpleDateFormat sdf = getTimeFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.parse(sdf.format(new Date(System.currentTimeMillis())), new ParsePosition(0));
    }

    /**
     * @param format
     * @Title: getTimeFormat
     * @Description: 获取时间格式
     * @return: SimpleDateFormat
     */
    private static SimpleDateFormat getTimeFormat(String format) {
        return new SimpleDateFormat(format);
    }
}
