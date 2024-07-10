import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class user_login {
      private int id;
      private String name,address,username,password;
      private long mobile;
      public void setID(int id) {
            this.id = id;
      }

      public int getID() {
            return id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getName() {
            return name;
      }

      public void setMobile(long mobile) {
            this.mobile = mobile;
      }

      public long getMobile() {
            return mobile;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public String getAddress() {
            return address;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getUsername() {
            return username;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getPassword() {
            return password;
      }

      public void User_login(){
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM user_details WHERE Username = '" + getUsername() + "' and Password = '"
                              + getPassword() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        User_Menu menu=new User_Menu();
                        menu.user_menu();
                  } else {
                        System.out.println("Login Failed");
                  }
                  rs.close();
                  ps.close();
                  conn.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      public void fetchdetails(String username){
            try{
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql="SELECT * FROM user_details WHERE Username = '"+username+"'";
                  PreparedStatement ps=conn.prepareStatement(sql);
                  ResultSet rs=ps.executeQuery();
                  if(rs.next())
                        System.out.println("Customer Name :"+rs.getString(2));
                  else
                        System.out.println("Name not Found");
            }catch(Exception e){
                  System.out.println(e);
            }
      }

      public void user_registration(){
            try{
                  Class.forName(DB.classname);
                  Connection conn=DriverManager.getConnection(DB.URL,DB.USERNAME,DB.PASSWORD);
                  String sql="INSERT INTO user_details (ID,Name,Mobile,Address,Username,Password)VALUES('"+getID()+"','"+getName()+"','"+getMobile()+"','"+getAddress()+"','"+getUsername()+"','"+getPassword()+"')";
                  PreparedStatement ps=conn.prepareStatement(sql);
                  int i=ps.executeUpdate();
                  if(i>0){
                        System.out.println("Registration Successfull");
                  }else{
                        System.out.println("Registration Failed");
                  }
            }catch(Exception e){
                  System.out.println(e);
            }
      }
}
