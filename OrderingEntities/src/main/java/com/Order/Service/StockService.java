package com.Order.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Order.Models.Stock;
import com.Order.Repository.StockRepository;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

}
