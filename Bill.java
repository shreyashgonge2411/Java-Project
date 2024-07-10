import java.sql.*;
import java.time.LocalDate;

class  Bills {
      LocalDate currentDate = LocalDate.now();
      int bill_id, quentity, id;// Generate Random
      String c_name, product;
      double p_rate, total_prise;

      public void setBill_id(int bill_id) {
            this.bill_id = bill_id;
      }

      public int getBill_id() {
            return bill_id;
      }

      public void setQuentity(int quentity) {
            this.quentity = quentity;
      }

      public int getQuentity() {
            return quentity;
      }

      public void setName(String c_name) {
            this.c_name = c_name;
      }

      public String getName() {
            return c_name;
      }

      public void setProduct(String product) {
            this.product = product;
      }

      public String getProduct() {
            return product;
      }

      public void setProduct_Rate(double p_rate) {
            this.p_rate = p_rate;
      }

      public double getProduct_Rate() {
            return p_rate;
      }

      public void setTotal(double total_prise) {
            this.total_prise = total_prise;
      }

      public double getTotal() {
            return total_prise;
      }

      public void setID(int id) {
            this.id = id;
      }

      public int getID() {
            return id;
      }

      public void Generate_bill() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "INSERT INTO bills(Bill_ID,Date,Customer_Name,Product_Name,Rate,Quentity,Total)VALUES('"
                              + getBill_id() + "','" + currentDate + "','" + getName() + "','" + getProduct() + "','"
                              + getProduct_Rate() + "','" + getQuentity() + "','" + getTotal() + "')";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  int i = ps.executeUpdate();

                  if (i > 0) {
                        System.out.println("Bill Added");
                  } else {
                        System.out.println("Failed");
                  }
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      public void Print() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM bills WHERE Bill_ID = '" + getID() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        int b_no = rs.getInt(1);
                        String date = rs.getString(2);
                        String name = rs.getString(3);
                        String product = rs.getString(4);
                        double rate = rs.getDouble(5);
                        int quentity = rs.getInt(6);
                        double total = rs.getDouble(7);
                        System.out.println(
                                    "                        ****************************************\n                                 KrishiOn Agro Agency\n                        ****************************************");
                        System.out.println("**********************\n   Bill No : " + b_no
                                    + "                                                   Date" + date
                                    + "\n**********************");
                        // System.out.println("Date "+date);admin
                        System.out.println("Customer Name : " + name);
                        System.out.println(
                                    "*************************************************************************************************");
                        System.out.println(
                                    "|Product Name |            | Quantity |             |    Rate    |             |     Total     |");
                        System.out.println("|    " + product + "     |            |    " + quentity
                                    + "    |             |    " + rate + "   |             |     " + total + "    |");
                        System.out.println(
                                    "*************************************************************************************************");
                        System.out.println();
                        System.out.println(
                                    "Place :                                                                    ___________________\n                                                                                Customer Sign");
                  } else {
                        System.out.println("Bill Not Found");
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      public void Display_Bills() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM bills";
                  PreparedStatement ps = conn.prepareStatement(sql);

                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                        System.out.println("*****************************************");
                        System.out.println("Bill ID--->" + rs.getString(1));
                        System.out.println("Customer Name--->" + rs.getString(3));
                        System.out.println("Date--->" + rs.getString(2));
                        System.out.println("*****************************************");
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void Delete_Bill() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "DELETE FROM bills WHERE Bill_ID = '" + getID() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  int i = ps.executeUpdate();
                  if (i > 0) {
                        System.out.println("Bill Details Deleted");
                  } else {
                        System.out.println("Bill Does not Exists");
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

}