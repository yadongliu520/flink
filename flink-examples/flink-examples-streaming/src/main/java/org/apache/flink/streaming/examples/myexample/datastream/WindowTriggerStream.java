package org.apache.flink.streaming.examples.myexample.datastream;

<<<<<<< Updated upstream
=======
import org.apache.flink.api.dag.Transformation;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

>>>>>>> Stashed changes
/**
 * @Description: 窗口时间触发
 * @Author: Adam
 * @Date: 2021-01-27 23:50
 **/
<<<<<<< Updated upstream
public class WIndowTrigger {
=======
public class WindowTriggerStream extends DataStream {
    /**
     * Create a new {@link DataStream} in the given execution environment with partitioning set to
     * forward by default.
     *
     * @param environment    The StreamExecutionEnvironment
     * @param transformation
     */
    public WindowTriggerStream(StreamExecutionEnvironment environment, Transformation transformation) {
        super(environment, transformation);
    }
>>>>>>> Stashed changes
}
