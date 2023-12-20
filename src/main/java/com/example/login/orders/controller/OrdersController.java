package com.example.login.orders.controller;

import com.example.login.orders.model.OrdersDto;
import com.example.login.orders.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    // CREATE
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(Integer memberid, Integer productid, OrdersDto ordersDto) {
        ordersService.create(memberid, productid, ordersDto);

        return ResponseEntity.ok().body("주문 작성 성공");
    }

    // LIST 조회
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(ordersService.list());
    }

    // READ 조회
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(Integer id) {
        return ResponseEntity.ok().body(ordersService.read(id));
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(OrdersDto ordersDto) {
        ordersService.update(ordersDto);

        return ResponseEntity.ok().body("주문 수정 성공");
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(Integer id) {
        ordersService.delete(id);
        return ResponseEntity.ok().body("주문 삭제 성공");
    }
}
