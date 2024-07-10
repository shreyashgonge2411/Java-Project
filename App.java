import java.util.*;

public class App {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random rnd=new Random();
            try {
                  while (true) {
                        System.out.println(
                                    "              **************************\n              *  KrishiOn Agri Agency  *\n              **************************");
                        System.out.println("********************************************************");
                        System.out.println("1.Admin Login");
                        System.out.println("2.User Login");
                        System.out.println("3.User Registration");
                        System.out.println("********************************************************");
                        System.out.print("Enter Your Choice--->");
                        int ch1 = sc.nextInt();

                        switch (ch1) {
                              case 1:
                                    System.out.println(
                                                "                *********************\n                   ADMIN LOGIN\n              *********************");
                                    System.out.print("Enter Username--->");
                                    sc.nextLine(); // Consume the newline character left by nextInt()
                                    String a_user = sc.nextLine();

                                    System.out.print("Enter Password--->");
                                    String a_pass = sc.nextLine();

                                    Admin_login al = new Admin_login();
                                    al.setEmail(a_user);
                                    al.setPassword(a_pass);
                                    al.admin_login();
                                    break;
                              case 2:
                                    System.out.println(
                                                "                *********************\n                   ADMIN LOGIN\n              *********************");
                                    System.out.print("Enter Username--->");
                                    sc.nextLine(); // Consume the newline character left by nextInt()
                                    String user = sc.nextLine();

                                    System.out.print("Enter Password--->");
                                    String pass = sc.nextLine();

                                    user_login login = new user_login();
                                    login.setUsername(user);
                                    login.setPassword(pass);
                                    login.fetchdetails(user);
                                    login.User_login();
                                    break;
                              case 3:
                                    int val=rnd.nextInt(111111,999999);
                                    System.out.println("Customer ID--->"+val);

                                    System.out.print("Enter a Name--->");
                                    sc.nextLine();
                                    String name=sc.nextLine();

                                    System.out.print("Enter a Mobile No--->");
                                    long mob=sc.nextLong();

                                    System.out.print("Enter Address--->");
                                    sc.nextLine();
                                    String address=sc.nextLine();

                                    System.out.print("Enter Username--->");
                                    String username=sc.nextLine();

                                    System.out.print("Enter Password--->");
                                    String password=sc.nextLine();

                                    user_login users=new user_login();
                                    users.setID(val);
                                    users.setName(name);
                                    users.setMobile(mob);
                                    users.setAddress(address);
                                    users.setUsername(username);
                                    users.setPassword(password);
                                    users.user_registration();
                                    break;
                              default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                        }
                  }
            } catch (InputMismatchException ie) {
                  System.out.println("Wrong input");
                  sc.next(); // Clear the invalid input
            } finally {
                  sc.close(); // Close the scanner to prevent resource leaks
            }
      }

}