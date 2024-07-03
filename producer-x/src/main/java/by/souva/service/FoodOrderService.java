package by.souva.service;

import by.souva.domain.FoodOrder;
import by.souva.service.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderService {

    private final Producer producer;

    public String createFoodOrder(FoodOrder foodOrder) {
        return producer.createFoodOrder(foodOrder);
    }

}
