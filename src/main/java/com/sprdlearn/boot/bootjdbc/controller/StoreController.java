package com.sprdlearn.boot.bootjdbc.controller;

import com.sprdlearn.boot.bootjdbc.beans.Store;
import com.sprdlearn.boot.bootjdbc.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/stores")
    public String viewStores(Model model) {
        List<Store> stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "store-list";
    }

}
