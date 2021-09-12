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

        // delivery 객체 생성 //
         StockDelivery delivery = new StockDelivery();

         delivery.setOrderId(orderPlaced.getId());
         delivery.setCustomerId(orderPlaced.getUserId());
         delivery.setOrderDate(orderPlaced.getOrderDate());
         delivery.setPhoneNo(orderPlaced.getPhoneno());
         delivery.setProductId(orderPlaced.getProductid());
         delivery.setQty(parseInt(orderPlaced.getQty())); 
         delivery.setDeliveryStatus("delivery Started");

         System.out.println("==================================");
         System.out.println(orderPlaced.toString());
         System.out.println("==================================");

         stockDeliveryRepository.save(delivery);

    }
    private Integer parseInt(String qty) {
        return null;
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancleOrder(@Payload OrderCanceled orderCanceled){

        if(!orderCanceled.validate()) return;

        Long orderId =Long.valueOf(orderCanceled.getId());
        stockDeliveryRepository.deleteById(orderId); 

    }

  
}
