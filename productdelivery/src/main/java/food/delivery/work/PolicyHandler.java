package food.delivery.work;

import food.delivery.work.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

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
         delivery.setPhoneNo(orderPlaced.getPhoneNo());
         delivery.setProductId(orderPlaced.getProductId());
         delivery.setQty(orderPlaced.getQty()); 
         delivery.setDeliveryStatus("delivery Started");

         System.out.println("==================================");
         System.out.println(orderPlaced.getId());
         System.out.println(orderPlaced.toJson());
         System.out.println("==================================");
         System.out.println(delivery.getOrderId());

         stockDeliveryRepository.save(delivery);

    }
    private Integer parseInt(String qty) {
        return null;
    }
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancleOrder(@Payload OrderCanceled orderCanceled){

        if(!orderCanceled.validate()) return;

        Long orderId =Long.valueOf(orderCanceled.getId());
        stockDeliveryRepository.deleteById(orderId); 
        
        stockDeliveryRepository.s

    }
    */
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancleOrder(@Payload OrderCanceled orderCanceled) {
    	
    	if(!orderCanceled.validate()) return;
    	System.out.println("\n\n##### #$!%#$%@#$%@#$%@#$%@#$%@#$% test !@#$!@#$!@#$!@#$!@#$@!#$\n\n");
        List<StockDelivery> deliveryList = stockDeliveryRepository.findByOrderId(orderCanceled.getId());

        for (StockDelivery delivery:deliveryList)
        {
            delivery.setDeliveryStatus("delivery Canceled");
            stockDeliveryRepository.save(delivery);
        }

       
    }

  
}
