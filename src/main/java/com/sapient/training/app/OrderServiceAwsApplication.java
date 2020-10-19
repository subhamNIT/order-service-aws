package com.sapient.training.app;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.training.model.Order;
import com.sapient.training.repo.OrderDao;

@SpringBootApplication(scanBasePackages = "com.sapient.training")
@RestController
@RequestMapping("/orders")
public class OrderServiceAwsApplication {
	@Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
    }
    
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceAwsApplication.class, args);
	}

}
