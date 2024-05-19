package com.chat.chat.service;

import com.chat.chat.request.GroceryItemRequest;
import com.chat.chat.response.GroceryItemResponse;

import java.util.List;

public interface GroceryService {

    List<GroceryItemResponse> findAllGroCeryItem();

    GroceryItemResponse insertGroCeryItem(GroceryItemRequest groceryItemRequest);
}
