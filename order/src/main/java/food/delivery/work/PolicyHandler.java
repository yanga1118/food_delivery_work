package food.delivery.work;

import food.delivery.work.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_UpdateOrderStatus(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;

        System.out.println("\n\n##### listener UpdateOrderStatus : " + deliveryStarted.toJson() + "\n\n");

        List<Order> orderList = orderRepository.findByClassId(deliveryStarted.getOrderId());
        
        for(Order order : orderList) {
        	order.setOrderStatus("deliveryStarted");
        	orderRepository.save(order);
        }

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCancled_UpdateOrderStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener UpdateOrderStatus : " + deliveryCanceled.toJson() + "\n\n");

        List<Order> orderList = orderRepository.findByClassId(deliveryCanceled.getOrderId());
        
        for(Order order : orderList) {
        	order.setOrderStatus("deliveryCanceled");
        	orderRepository.save(order);
        	
        }

    }
   

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
