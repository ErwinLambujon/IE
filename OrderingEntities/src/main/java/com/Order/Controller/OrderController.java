package com.Order.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Order.Models.Order;
import com.Order.Service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrders")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }


    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order deletedOrder = orderService.deleteOrder(id);
        if(deletedOrder != null) {
            return ResponseEntity.ok(deletedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
