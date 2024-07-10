import java.sql.*;
import java.util.*;

class Admin_Menu {
      Scanner sc = new Scanner(System.in);
      Random rnd = new Random();
      Admin_login al = new Admin_login();
      Product pd = new Product();

      public void Menu() {
            while (true) {
                  System.out.println("*****************************************");
                  System.out.println("1.Manage Product");
                  System.out.println("2.Sale");
                  System.out.println("3.Check Stock");
                  System.out.println("4.Add Stock");
                  System.out.println("5.Customer Details");
                  System.out.println("6.Change Password");
                  System.out.println("0.Logout");
                  System.out.println("*****************************************");
                  System.out.print("Enter Your Choise--->");
                  int ch1 = sc.nextInt();

                  switch (ch1) {
                        case 1:
                              manage_product();
                              break;
                        case 2:
                              manage_sell();
                              break;
                        case 3:
                              pd.Stock();
                              break;
                        case 4:
                              System.out.print("Enter a Product ID--->");
                              int id = sc.nextInt();
                              pd.setId(id);

                              System.out.print("Enter a Quentity--->");
                              int qnt = sc.nextInt();
                              pd.setQuentity(qnt);
                              pd.Add_Quentity();
                              break;
                        case 5:
                              Customers();
                              break;
                        case 6:
                              System.out.print("Enter a Current Password--->");
                              sc.nextLine();
                              String currentpass = sc.nextLine();

                              System.out.print("Enter new Pasword--->");
                              String n_pass = sc.nextLine();

                              System.out.print("Confirm New Password--->");
                              String c_pass = sc.nextLine();

                              al.setcurentpassword(currentpass);
                              al.setPassword(n_pass);
                              al.setRepassword(c_pass);
                              al.manage_password();
                              break;
                        case 0:
                              System.out.println("Logging Out");
                              return;
                        default:
                              System.out.println("Invalid Input...!");
                              break;
                  }
            }

      }

      private void manage_product() {
            try {
                  while (true) {
                        System.out.println("*****************************************");
                        System.out.println("1.Add Product");
                        System.out.println("2.Update Product");
                        System.out.println("3.Delete Product");
                        System.out.println("4.View All Product");
                        System.out.println("0.Back to Main Menu");
                        System.out.println("*****************************************");
                        System.out.print("Enter Your Choise--->");
                        int ch2 = sc.nextInt();

                        Product product = new Product();
                        switch (ch2) {
                              case 1:
                                    int val = rnd.nextInt(111111, 999999);
                                    product.setId(val);

                                    System.out.println("Product ID---->" + product.getId());

                                    System.out.print("Enter a Product Name--->");
                                    sc.nextLine();
                                    String name = sc.nextLine();

                                    System.out.print("Enter Prodcut Category--->");
                                    String cate = sc.nextLine();

                                    System.out.print("Enter a Product Price--->");
                                    double price = sc.nextDouble();

                                    System.out.print("Enter a Quentity--->");
                                    int qnt = sc.nextInt();

                                    product.setProduct_Name(name);
                                    product.setProduct_Cate(cate);
                                    product.setProduct_Rate(price);
                                    product.setQuentity(qnt);
                                    product.Add_product();
                                    break;
                              case 2:
                                    System.out.print("Enter Product ID--->");
                                    int id = sc.nextInt();
                                    product.setId(id);
                                    System.out.println("********************************************************");
                                    System.out.println("1.Update Category");
                                    System.out.println("2.Update Price");
                                    System.out.println("0.Back to Main Menu");
                                    System.out.println("********************************************************");
                                    System.out.print("Enter Your Choise--->");
                                    int ch3 = sc.nextInt();

                                    switch (ch3) {
                                          case 1:
                                                System.out.print("Enter a Category--->");
                                                String u_cate = sc.nextLine();
                                                product.setProduct_Cate(u_cate);
                                                product.Update_Category();
                                                break;
                                          case 2:
                                                System.out.print("Enter a New Price--->");
                                                double u_price = sc.nextDouble();
                                                product.setProduct_Rate(u_price);
                                                product.Update_Price();
                                                break;
                                          case 0:
                                                return;
                                          default:
                                                System.out.println("Invalid Input...!");
                                                break;
                                    }
                                    break;
                              case 3:
                                    System.out.print("Enter Product ID--->");
                                    int d_id = sc.nextInt();
                                    product.setId(d_id);
                                    product.Delete();
                                    break;
                              case 4:
                                    product.Display();
                                    break;
                              case 0:
                                    return;
                              default:
                                    System.out.println("Invalid Input...!");
                                    break;
                        }
                  }
            } catch (InputMismatchException im) {
                  System.out.println();
            }
      }

      private void Customers() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM user_details";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                        int i = rs.getRow();
                        if (i > 0) {
                              System.out.println(i);
                              int ID = rs.getInt(1);
                              String name = rs.getString(2);
                              long mob = rs.getLong(3);
                              String address = rs.getString(4);
                              String username = rs.getString(5);
                              System.out.println("Customer ID--->" + ID);
                              System.out.println("Customer Name--->" + name);
                              System.out.println("Mobile No--->" + mob);
                              System.out.println("Address--->" + address);
                              System.out.println("Customer Username--->" + username);
                        } else {
                              System.out.println("Data Not Found");
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
                        int qnt = sc.nextInt();                        if (count > qnt) {
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

      private void manage_sell() {
            while (true) {
                  System.out.println("*****************************************");
                  System.out.println("1.Bill");
                  System.out.println("2.Print Bill");
                  System.out.println("3.Display Bill No");
                  System.out.println("4.Delete Bill");
                  System.out.println("0. Back to Main Menu");
                  System.out.println("*****************************************");
                  System.out.print("Enter Your Choise--->");
                  int ch6 = sc.nextInt();
                  Bills bill = new Bills();
                  switch (ch6) {
                        case 1:
                              fetchdata();// call Method
                              break;
                        case 2:
                              System.out.print("Enter Bill No--->");
                              int bill_no = sc.nextInt();
                              bill.setID(bill_no);
                              bill.Print();
                              break;
                        case 3:
                              bill.Display_Bills();
                              break;
                        case 4:
                              System.out.print("Enter a Bill No--->");
                              int d_id = sc.nextInt();
                              bill.setID(d_id);
                              bill.Delete_Bill();
                              break;
                        case 0:
                              return;
                        default:
                              System.out.println("Invalid Input...!");
                              break;
                  }
            }
      }
}