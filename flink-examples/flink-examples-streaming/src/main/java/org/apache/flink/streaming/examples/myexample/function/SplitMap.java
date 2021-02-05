package org.apache.flink.streaming.examples.myexample.function;

<<<<<<< Updated upstream
=======
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;

>>>>>>> Stashed changes
/**
 * @Description:
 * @Author: Adam
 * @Date: 2021-01-27 23:58
 **/
<<<<<<< Updated upstream
public class SplitMap {
=======
public class SplitMap implements MapFunction<String, Tuple4<String, Integer, Integer, Long> > {
    @Override
    public Tuple4<String, Integer, Integer, Long> map(String value) {
        String[] arr=value.split(",");
        return new Tuple4<>(arr[0].trim(), Integer.parseInt(arr[1].trim()), Integer.parseInt(arr[2].trim()), Long.parseLong(arr[3].trim()));
    }
>>>>>>> Stashed changes
}
