package org.apache.flink.streaming.examples.myexample;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Description: 验证reduce逻辑
 * @Author: Adam
 * @Date: 2021-01-20 08:14
 **/
public class ReduceExample {
    public static void main(String[] args) throws Exception {
        final String hostname="localhost";
        final int port=12345;

        // get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // get input data by connecting to the socket
        DataStream<String> text = env.socketTextStream(hostname, port, "\n");

        final StreamExecutionEnvironment env2= StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> text2 = env.socketTextStream(hostname, port);

        DataStream<Tuple2<String, Long>> s1 = text2.flatMap(
                new FlatMapFunction<String, Tuple2<String, Long>>() {
                    @Override
                    public void flatMap(
                            String value,
                            Collector<Tuple2<String, Long>> out) throws Exception {
                        String[] arr = value.split("\\W+");
                        for(String word: arr){
                            out.collect(Tuple2.of(word, 1L));
                        };
                    }
                }
        )
                .keyBy(value ->value.f0)
                .reduce(new ReduceFunction<Tuple2<String, Long>>() {
                    @Override
                    public Tuple2<String, Long> reduce(
                            Tuple2<String, Long> value1,
                            Tuple2<String, Long> value2) throws Exception {
                        return Tuple2.of(value1.f0, value1.f1+value2.f1);
                    }
                });
        s1.print();
        env.execute();

    }
}
