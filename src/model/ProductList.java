package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private Connection conn;

    public ProductList(Connection conn) {
        this.conn = conn;
    }

    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
            try{
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                        rs.getString("productName"),
                        rs.getInt("categoryID"),
                        rs.getInt("ProductPrice"),
                        rs.getInt("ProductQuantity"),
                        rs.getInt("SupplierID")
                        ));
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
