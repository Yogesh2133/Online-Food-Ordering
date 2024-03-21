package com.yogesh.controller;

import com.yogesh.Service.OrderService;
import com.yogesh.Service.UserService;
import com.yogesh.model.Order;
import com.yogesh.model.User;
import com.yogesh.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder
            (@RequestBody OrderRequest req,
             @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.createOrder(req,user);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory
            (@RequestBody OrderRequest req,
             @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Order> orders=orderService.getUsersOrder(user.getId());
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
