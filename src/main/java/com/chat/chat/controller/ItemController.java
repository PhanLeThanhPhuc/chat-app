package com.chat.chat.controller;
import com.chat.chat.request.GroceryItemRequest;
import com.chat.chat.response.GroceryItemResponse;
import com.chat.chat.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("items")
public class ItemController {

    @Autowired
    GroceryService groceryService;

    @GetMapping("items")
    public List<GroceryItemResponse> test() {
        List<GroceryItemResponse> test = groceryService.findAllGroCeryItem();
        return test;
    }

    @PostMapping("items")
    public GroceryItemResponse insert(@RequestBody GroceryItemRequest groceryItemRequest){
        return groceryService.insertGroCeryItem(groceryItemRequest);
    }

}
