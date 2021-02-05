package org.apache.flink.streaming.examples.myexample;

<<<<<<< Updated upstream
=======
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.delta.DeltaFunction;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.evictors.TimeEvictor;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.DeltaTrigger;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.streaming.examples.myexample.function.SplitMap;
import org.apache.flink.streaming.examples.myexample.watermarkstrategy.SimpleTimeWartermarkStrategy;

import java.util.concurrent.TimeUnit;

>>>>>>> Stashed changes
/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-01-27 23:53
 **/
public class WindowTriggerExample {
<<<<<<< Updated upstream
=======
    public static void main(String[] args) throws Exception {
        final String hostname="localhost";
        final int port=12345;

        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream(hostname, port, "\n");

        DataStream<Tuple4<String, Integer, Integer, Long>> s1 = text.map(new SplitMap());
        int evictorTime=10;
        double triggerMeter=10;
        final int windowSize = 5;
        final int slideSize =  2;


        DataStream<Tuple4<String, Integer, Integer, Long>> s2 = s1.assignTimestampsAndWatermarks(new SimpleTimeWartermarkStrategy<>())
                .keyBy(value -> value.f0)
                .countWindow(windowSize,slideSize)
                .sum(1);
//                .window(GlobalWindows.create())
//                .evictor(TimeEvictor.of(Time.of(evictorTime, TimeUnit.SECONDS)))
//                .trigger(DeltaTrigger.of(
//                        triggerMeter,
//                        new DeltaFunction<Tuple4<String, Integer, Integer, Long>>() {
//                            @Override
//                            public double getDelta(
//                                    Tuple4<String, Integer, Integer, Long> oldDataPoint,
//                                    Tuple4<String, Integer, Integer, Long> newDataPoint) {
//                                int delta=newDataPoint.f2-oldDataPoint.f2;
//                                System.out.println("===delta: " + delta);
//                                return delta;
//                            }
//                        },
//                        s1.getType().createSerializer(env.getConfig()))
//                ).maxBy(1);

        s2.print();

        env.execute("WindowTriggerExample");
    }
>>>>>>> Stashed changes
}
