/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import LifeLine.model.Stock;
import lifeLine.DAO.JDBCConection;

/**
 *
 * @author qanh2
 */
public class StockDao {

    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<Stock>();
        Connection conn = lifeLine.DAO.JDBCConection.getConnection();
        String sql = "select * from stock";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Stock stock = new Stock(rs.getInt("item_code"),rs.getInt("icost"), rs.getInt("dnum"),rs.getInt("inum"),rs.getString("iname") );
            
                stocks.add(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public void updateStock(Stock stock) {
        //Connection conn = JDBCConection.getConnection();
        Connection conn = lifeLine.DAO.JDBCConection.getConnection();
        String sql = "update Stock set iname = ?, icost = ?, inum = ?, dnum = ? where item_code = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            pStatement.setString(1, stock.getIname());
            pStatement.setInt(2, stock.getIcost());
            pStatement.setInt(3, stock.getInum());
            pStatement.setInt(4, stock.getDnum());
            pStatement.setInt(5, stock.getId());
            
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public void deleteStock(int id) {
        Connection conn = JDBCConection.getConnection();
        String sql = "delete from Stock where item_code = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            int rs = pStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
    
    public void addStock(Stock stock) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Stock(item_code ,iname ,icost ,inum ,dnum ) values(?,?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, stock.getId());
            pStatement.setString(2, stock.getIname());
            pStatement.setInt(3, stock.getIcost());
            pStatement.setInt(4, stock.getInum());
            pStatement.setInt(5, stock.getDnum());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public Stock getStocksById(int id) {
        
        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Stock where item_code = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Stock stock = new Stock();
                
                stock.setId(rs.getInt("item_code"));
                stock.setIname(rs.getString("iname"));
                stock.setIcost(rs.getInt("icost"));
                stock.setInum(rs.getInt("inum"));
                stock.setDnum(rs.getInt("dnum"));
                
                return stock;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}