package com.bookshelf.web;

import com.bookshelf.constant.PageConstants;
import com.bookshelf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.getOrders());
        return "orderview";
    }

    @DeleteMapping("/{orderNo}")
    @ResponseBody
    public String deleteOrder(@PathVariable("orderNo") String orderNo){
        orderService.deleteOrder(orderNo);
        return "order deleted";
    }

    @PostMapping("/{orderNo}")
    @ResponseBody
    public String approveOrder(@PathVariable("orderNo") String orderNo){
        orderService.approve(orderNo);
        return "order approved";
    }
}
