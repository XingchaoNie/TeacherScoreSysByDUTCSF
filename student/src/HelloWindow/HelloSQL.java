package HelloWindow;

import java.sql.*;
import javax.swing.*;

public class HelloSQL {
    Connection con = null;
    Statement statement = null;
    ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mingshuaitechnology?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    String name = "root";
    String passwd = "12345678";

    public HelloSQL() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, name, passwd);
            statement = con.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("引包错误");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String admin, String password){
        if (compare(admin, password)) {
            JOptionPane.showMessageDialog(null, "已经完成删除");
        } else {
            return;
        }
        String sql = "delete from workers where admin=\"" + admin + "\"";
        try {
            int a = statement.executeUpdate(sql);
            con.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "不存在该用户！");
            e.printStackTrace();
        }
    }

    public boolean ResetPassword(String admin1, String password, String newPassword){
        boolean ResetSignal = false;
        boolean s = compare(admin1, password);
        if (s) {
            String sql = "update workers set password=\"" + newPassword + "\" where admin=\"" + admin1 + "\"";
            try {
                int a = statement.executeUpdate(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "密码修改成功！");
                    ResetSignal = true;
                }
                con.close();
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "用户不存在！");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }
        return ResetSignal;

    }

    public boolean exist(String admin){
        return false;
    }
    public void signIn(String admin,String password){
        if (admin == null || admin.trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "注册账号为空，请重新输入！");
            return;
        }
        String sql = "insert into workers(admin,password) values(\"" + admin + "\",\"" + password + "\")";
        try {
            int a = statement.executeUpdate(sql);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
            e.printStackTrace();
        }
    }

    public boolean compare(String username, String password) {
        boolean sig = false;
        String sql = "select password from workers where admin=\"" + username + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + password);
                if (pa.equals(password)) {
                    sig = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sig;
    }

    public boolean compare(String username, String password, int closeSIG) {
        boolean sig = false;
        String sql = "select password from workers where admin=\"" + username + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + password);
                if (pa.equals(password)) {
                    sig = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在！");
            }
            res.close();
            con.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sig;
    }
}

