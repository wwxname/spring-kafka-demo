package platform;

import ch.qos.logback.classic.Level;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import ch.qos.logback.classic.Logger;
/**
 * @author plus me
 * @date 2018/7/30
 */

public class MainTest {

    public static void  main(String args[]){


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //生产者发送消息
        String topic = "demo";
        Producer<String, String> procuder = new KafkaProducer<String,String>(props);
        //procuder.

        for (int i = 1; i <= 1; i++) {
            String value = "value_" + i;
            System.err.println(value);
            ProducerRecord<String, String> msg = new ProducerRecord<String, String>(topic, value);
            procuder.send(msg);
        }
        //列出topic的相关信息
        List<PartitionInfo> partitions = new ArrayList<PartitionInfo>() ;
        partitions = procuder.partitionsFor(topic);
        for(PartitionInfo p:partitions)
        {
            System.err.println(p);
        }

        System.err.println("send message over.");
        procuder.close(100, TimeUnit.MILLISECONDS);
    }
}
