import java.sql.*;

class Admin_login {
      String email, pass, password, currentpass;

      public void setEmail(String email) {
            this.email = email;
      }

      public String getEmail() {
            return email;
      }

      public void setPassword(String pass) {
            this.pass = pass;
      }

      public String getPassword() {
            return pass;
      }

      public void setRepassword(String password) {
            this.password = password;
      }

      public String getRePassword() {
            return password;
      }

      public void setcurentpassword(String currentpass) {
            this.currentpass = currentpass;
      }

      public String getcurentpassword() {
            return currentpass;
      }

      public void admin_login() {
            try {

                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM login_db WHERE Username = '" + getEmail() + "' and Password = '"
                              + getPassword() + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();

                  if (rs.next()) {
                        Admin_Menu am = new Admin_Menu();
                        am.Menu();
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

      public void manage_password() {
            try {
                  Class.forName(DB.classname);
                  Connection conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
                  String sql = "SELECT * FROM login_db WHERE ID = '" + 1 + "'";
                  PreparedStatement ps = conn.prepareStatement(sql);

                  ResultSet rs = ps.executeQuery();
                  if (rs.next()) {
                        String dbpass = rs.getString(3);
                        String currentpass = getcurentpassword();
                        String pass1 = getPassword();
                        String pass2 = getRePassword();

                        if (dbpass.equals(currentpass)) {
                              if (pass1.equals(pass2)) {
                                    String sql1 = "UPDATE login_db SET Password = '" + getRePassword()
                                                + "' WHERE ID = '"
                                                + 1 + "'";
                                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                                    int i = ps1.executeUpdate();
                                    if (i > 0) {
                                          System.out.println("Password has been changed");
                                    } else {
                                          System.out.println("Failed");
                                    }
                              } else {
                                    System.out.println("New password does not macth");
                              }
                        } else {
                              System.out.println("Current Password does not matched");
                        }

                  }

            } catch (Exception e) {
                  System.out.println(e);
            }
      }
}