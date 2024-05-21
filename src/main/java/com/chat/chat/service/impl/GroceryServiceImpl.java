package com.chat.chat.service.impl;

import com.chat.chat.entity.GroceryItem;
import com.chat.chat.repository.ItemRepository;
import com.chat.chat.request.GroceryItemRequest;
import com.chat.chat.response.GroceryItemResponse;
import com.chat.chat.service.GroceryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroceryServiceImpl implements GroceryService{

    ItemRepository itemRepository;

    @Override
    public List<GroceryItemResponse> findAllGroCeryItem() {
        List<GroceryItem> groceryItem = itemRepository.findAll();
        List<GroceryItemResponse> responses = new ArrayList<>();

        for (GroceryItem item : groceryItem) {
            GroceryItemResponse response = new GroceryItemResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setQuantity(item.getQuantity());
            responses.add(response);
        }

        return responses;

    }

        @Override
        public GroceryItemResponse insertGroCeryItem(GroceryItemRequest groceryItemRequest) {
            GroceryItem groceryItem = new GroceryItem();
            groceryItem.setName(groceryItemRequest.getName());
            groceryItem.setQuantity(groceryItemRequest.getQuantity());
            GroceryItem savedItem = itemRepository.save(groceryItem);

            GroceryItemResponse response = new GroceryItemResponse();
            response.setId(savedItem.getId());
            response.setName(savedItem.getName());
            response.setQuantity(savedItem.getQuantity());

            return response;
        }

}
