package food.delivery.work;

import food.delivery.work.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired StockDeliveryRepository stockDeliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_AcceptOrder(@Payload OrderPlaced orderPlaced){

        if(!orderPlaced.validate()) return;

        System.out.println("\n\n##### listener AcceptOrder : " + orderPlaced.toJson() + "\n\n");



        // Sample Logic //
        // StockDelivery stockDelivery = new StockDelivery();
        // stockDeliveryRepository.save(stockDelivery);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancleOrder(@Payload OrderCanceled orderCanceled){

        if(!orderCanceled.validate()) return;

        System.out.println("\n\n##### listener CancleOrder : " + orderCanceled.toJson() + "\n\n");



        // Sample Logic //
        // StockDelivery stockDelivery = new StockDelivery();
        // stockDeliveryRepository.save(stockDelivery);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCouponPublished_CancleOrder(@Payload CouponPublished couponPublished){

        if(!couponPublished.validate()) return;

        System.out.println("\n\n##### listener CancleOrder : " + couponPublished.toJson() + "\n\n");



        // Sample Logic //
        // StockDelivery stockDelivery = new StockDelivery();
        // stockDeliveryRepository.save(stockDelivery);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
