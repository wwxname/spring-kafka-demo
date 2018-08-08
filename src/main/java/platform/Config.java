package platform;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Optional;


/**
 * topic一样，组id不一样。可以实现订阅发布
 * @author superwen
 * @date 2018/4/20 下午2:38
 */
@Component
public class Config {
    @KafkaListener(topics = "demo", groupId = "wwx")
    public void test(ConsumerRecord<?, ?> consumerRecord) throws UnsupportedEncodingException {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            String mes = new String((byte[]) message, "UTF-8");
            System.err.println(">>>>>>>>接收消息message =" + mes);
        }
    }
    public void test(){
        RefreshRemoteApplicationEvent refreshRemoteApplicationEvent;
        AckRemoteApplicationEvent ackRemoteApplicationEvent;
    }
}
@Component
class Config2 {
    @KafkaListener(topics = "demo", groupId = "wwj")
    public void test(ConsumerRecord<?, ?> consumerRecord) throws UnsupportedEncodingException {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            String mes = new String((byte[]) message, "UTF-8");
            System.err.println(">>>>>>>>2接收消息message =" + mes);
        }
    }
    public void test(){
        RefreshRemoteApplicationEvent refreshRemoteApplicationEvent;
        AckRemoteApplicationEvent ackRemoteApplicationEvent;
    }
}

