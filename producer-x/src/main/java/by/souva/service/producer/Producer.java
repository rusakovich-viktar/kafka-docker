package by.souva.service.producer;

import by.souva.domain.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor

public class Producer {
    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public String createFoodOrder(FoodOrder foodOrder) {
        String foodOrderJson = null;
        try {
            foodOrderJson = objectMapper.writeValueAsString(foodOrder);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        kafkaTemplate.send(orderTopic, foodOrderJson);
        return foodOrderJson;
    }
}
