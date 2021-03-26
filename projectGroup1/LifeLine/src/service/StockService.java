/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import dao.StockDao;
import model.Stock;

/**
 *
 * @author qanh2
 */
public class StockService {
    private StockDao stockDao;
    
    public StockService(){
        stockDao = new StockDao();
    }
    
    public List<Stock> getAllStocks(){
        return stockDao.getAllStocks();
    }
    
    public void addStock(Stock stock){
        stockDao.addStock(stock);
    }
    
    public void deleteStock(int id){
        stockDao.deleteStock(id);
    }
    
    public Stock getStockById(int id){
        return stockDao.getStocksById(id);
    }
    
    public void updateStock(Stock stock){
        stockDao.updateStock(stock);
    }
}
