package com.Order.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Order.Models.Stock;
import com.Order.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/addStock")
    public ResponseEntity<?> addStock(@RequestBody Stock stock) {
        Stock added_stock = stockService.addStock(stock);
        return ResponseEntity.ok(added_stock);
    }


    @GetMapping("/getStocks")
    public ResponseEntity<?> getStocks() {
        return ResponseEntity.ok(stockService.getStocks());
    }


    @PutMapping("/modifyStock")
    public ResponseEntity<?> modifyStock(@RequestBody Stock stock) throws Exception {

        return null;
    }

}
