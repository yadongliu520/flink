package org.apache.flink.streaming.examples.myexample.windows;

<<<<<<< Updated upstream
=======
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

import java.text.SimpleDateFormat;
import java.util.Date;

>>>>>>> Stashed changes
/**
 * @Description: 窗口开始时间为小时整点
 * @Author: Adam
 * @Date: 2021-01-26 00:16
 **/
<<<<<<< Updated upstream
public class TimeWindowOnHour {
=======
public class TimeWindowOnHour extends TimeWindow {
    public TimeWindowOnHour(long start, long end) {
        super(start, end);
    }

    /**
     * Method to get the window start for a timestamp.
     */
    public static long getWindowStartWithOffset(long timestamp, long offset, long windowSize) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        String str=format.format(new Date(timestamp));
        long time=0L;
        try{
                time = format.parse(str).getTime();
            }catch (Exception e){

        }
        return time;
    }
>>>>>>> Stashed changes
}
