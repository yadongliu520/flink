package org.apache.flink.streaming.examples.myexample.watermarkstrategy;

<<<<<<< Updated upstream
=======
import org.apache.flink.api.common.eventtime.AscendingTimestampsWatermarks;
import org.apache.flink.api.common.eventtime.TimestampAssigner;
import org.apache.flink.api.common.eventtime.TimestampAssignerSupplier;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkGeneratorSupplier;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.examples.join.WindowJoin;

>>>>>>> Stashed changes
/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-01-27 08:42
 **/
<<<<<<< Updated upstream
public class SimpleTimeWartermarkStrategy {
}
=======
public class SimpleTimeWartermarkStrategy<T>  implements WatermarkStrategy<T> {

    //private SimpleTimeWartermarkStrategy() {}

    public static <T> SimpleTimeWartermarkStrategy<T> create() {
        return new SimpleTimeWartermarkStrategy<>();
    }

    @Override
    public WatermarkGenerator<T> createWatermarkGenerator(
            WatermarkGeneratorSupplier.Context context) {
        return new AscendingTimestampsWatermarks<>();
    }

    @Override
    public TimestampAssigner<T> createTimestampAssigner(
            TimestampAssignerSupplier.Context context) {
        return (event, timestamp) -> ((Tuple4<String, Integer,Integer, Long>)event).f3;
    }
}

>>>>>>> Stashed changes
