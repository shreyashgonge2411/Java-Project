import java.sql.*;
import java.util.*;

public class User_Menu extends App {
      Scanner sc = new Scanner(System.in);
      Random rnd = new Random();
      user_login login = new user_login();

      String username;

      public void setUsername(String username) {
            this.username = username;
      }

      public String getUsername() {
            return username;
      }

      public void user_menu() {
            while (true) {
                  System.out.println("1.Buy Product");
                  System.out.println("2.Print Invoice");
                  System.out.println("3.Change Password");
                  System.out.println("0.Loging Out");
                  System.out.print("Enter Your Choise--->");
                  int ch1 = sc.nextInt();
                  Bills bill = new Bills();
                  switch (ch1) {
                        case 1:
                              fetchdata();
                              break;
                        case 2:
                              System.out.print("Enter Bill No--->");
                              int bill_no = sc.nextInt();
                              bill.setID(bill_no);
                              bill.Print();
                              break;
                        case 3:
                              System.out.print("Enter New Password--->");
                              sc.nextLine();
                              String pass1 = sc.nextLine();

                              System.out.print("Confirm New Password--->");
                              sc.nextLine();
                              String pass2 = sc.nextLine();
                              //changepassword(, pass1, pass2);
                              break;
                        case 0:
                              System.out.println("Logging Out");
                              return;
                        default:
                              break;
                  }
            }
      }

      public void changepassword(String username, String Pass1, String Pass2) {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  if (Pass1.equals(Pass2)) {
                        String sql = "UPDATE FROM user_details Password = '" + Pass2 + "' WHERE username = '" + username
                                    + "'";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        int i = ps.executeUpdate();
                        if (i > 0) {
                              System.out.println("Password Changed");
                        } else {
                              System.out.println("Failed");
                        }
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      public void fetchdata() {
            Bills bill = new Bills();
            Product pd = new Product();

            int bill_id = rnd.nextInt(111111, 999999);
            bill.setBill_id(bill_id);
            System.out.println("Bill ID--->" + bill.getBill_id());
            System.out.print("Enter Customer Name--->");
            sc.nextLine();
            String c_name = sc.nextLine();
            bill.setName(c_name);
            pd.Display1();
            System.out.print("Enter a Product ID--->");
            int p_id = sc.nextInt();

            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql1 = "SELECT * FROM productdb WHERE ID = '" + p_id + "'";
                  PreparedStatement ps = conn.prepareStatement(sql1);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        String prod = rs.getString(2);
                        System.out.println("Product Name--->" + prod);
                        bill.setProduct(prod);

                        int count = rs.getInt(5);
                        System.out.print("Enter a Quentity--->");
                        int qnt = sc.nextInt();
                        if (count > qnt) {
                              int total = count - qnt;
                              String sql2 = "UPDATE productdb SET Quentity = '" + total + "' WHERE ID = '" + p_id + "'";
                              PreparedStatement ps1 = conn.prepareStatement(sql2);
                              int i = ps1.executeUpdate();
                              bill.setQuentity(qnt);

                              double rate = rs.getDouble(4);
                              System.out.println("Rate--->" + rate);
                              bill.setProduct_Rate(rate);

                              double total1 = qnt * rate;
                              System.out.println("Total Bill--->" + total1);
                              bill.setTotal(total1);
                              bill.Generate_bill();
                        } else {
                              System.out.println("Product Stock Low");
                        }

                  } else {
                        System.out.println("Product does not Exist");
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

}
