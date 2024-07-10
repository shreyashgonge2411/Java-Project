import java.sql.*;

class Product {
      private int id, quentity;
      private String p_name, p_category;
      private double p_rate;

      public void setId(int id) {
            this.id = id;
      }

      public int getId() {
            return id;
      }

      public void setQuentity(int quentity) {
            this.quentity = quentity;
      }

      public int getQuentity() {
            return quentity;
      }

      public void setProduct_Name(String p_name) {
            this.p_name = p_name;
      }

      public String getProduct_Name() {
            return p_name;
      }

      public void setProduct_Cate(String p_category) {
            this.p_category = p_category;
      }

      public String getProduct_Cate() {
            return p_category;
      }

      public void setProduct_Rate(double p_rate) {
            this.p_rate = p_rate;
      }

      public double getProduct_Rate() {
            return p_rate;
      }

      public void Add_Quentity() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql1 = "SELECT * FROM productdb WHERE ID = '" + getId() + "'";
                  PreparedStatement ps1 = conn.prepareStatement(sql1);
                  ResultSet rs1 = ps1.executeQuery();

                  if (rs1.next()) {
                        int getstock = rs1.getInt(5);
                        int stock = getstock + getQuentity();

                        String sql2 = "UPDATE productdb SET Quentity = '" + stock + "' WHERE ID = '" + getId() + "'";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        int i = ps2.executeUpdate();

                        if (i > 0) {
                              System.out.println("Update Quentity");
                        } else {
                              System.out.println("Added Failed");
                        }
                        System.out.println(stock);
                  } else {
                        System.out.println("Failed");
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      public void Add_product() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "INSERT INTO productdb(ID,Product_Name,Category,Rate,Quentity)VALUES('" + getId() + "','"
                              + getProduct_Name() + "','" + getProduct_Cate() + "','" + getProduct_Rate() + "','"
                              + getQuentity() + "')";
                  PreparedStatement ps = conn.prepareStatement(sql);

                  int i = ps.executeUpdate();
                  if (i > 0) {
                        System.out.println("Product Added");
                  } else {
                        System.out.println("Failed");
                  }
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Update_Category() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "UPDATE productdb SET Category = '" + getProduct_Cate() + "' WHERE ID ='" + getId()
                              + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  int i = ps.executeUpdate();
                  if (i > 0) {
                        System.out.println("Category Update");
                  } else {
                        System.out.println("Failed");
                  }
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Update_Price() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "UPDATE productdb SET Rate = '" + getProduct_Rate() + "' WHERE ID ='" + getId() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  int i = ps.executeUpdate();
                  if (i > 0) {
                        System.out.println("Price Update");
                  } else {
                        System.out.println("Failed");
                  }
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Delete() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "DELETE FROM productdb WHERE ID = '" + getId() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  int i = ps.executeUpdate();
                  if (i > 0) {
                        System.out.println("Product Deleted");
                  } else {
                        System.out.println("Failed");
                  }
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Display() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM productdb";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                        System.out.println("********************************************************");
                        System.out.println("Product ID--->" + rs.getString(1));
                        System.out.println("Prodcut Name--->" + rs.getString(2));
                        System.out.println("Category--->" + rs.getString(3));
                        System.out.println("Price--->" + rs.getString(4));
                        System.out.println("********************************************************");
                  }
                  rs.close();
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Display1() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM productdb";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                        System.out.println("********************************************************");
                        System.out.println("Product ID--->" + rs.getString(1));
                        System.out.println("Prodcut Name--->" + rs.getString(2));
                        System.out.println("********************************************************");
                  }
                  rs.close();
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Stock() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM productdb";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                        System.out.println("********************************************************");
                        System.out.println("Product ID--->" + rs.getString(1));
                        System.out.println("Prodcut Name--->" + rs.getString(2));
                        System.out.println("Stock in Store--->" + rs.getInt(5));
                        System.out.println("********************************************************");
                  }
                  rs.close();
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
}