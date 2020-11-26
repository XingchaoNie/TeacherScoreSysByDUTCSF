package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import com.mysql.jdbc.Driver;

public class Add extends JFrame {

    JLabel jlnumber = new JLabel("    学号      ：");
    JLabel jlname = new JLabel("    姓名      ：");
    JLabel jlage = new JLabel("    年龄      ：");
    JLabel jlsex = new JLabel("    性别      ：");
    JLabel jlmath = new JLabel("  数学成绩   ：");
    private final JLabel jlenglish = new JLabel("     英语成绩   ：");
    private final JLabel jldata = new JLabel("数据结构成绩：");

    JTextField jtnumber = new JTextField("", 20);
    JTextField jtname = new JTextField("", 20);
    JTextField jtage = new JTextField("", 20);
    JTextField jtsex = new JTextField("", 20);
    JTextField jtmath = new JTextField("", 20);

    JButton buttonadd = new JButton("添加");
    JButton buttonreturn = new JButton("返回");
    private final JTextField jtenglish = new JTextField();

    private final JTextField jtdata = new JTextField();


    public Add() {
        jtdata.setBounds(100, 176, 220, 21);
        jtdata.setColumns(10);
        jtenglish.setBounds(100, 153, 220, 21);
        jtenglish.setColumns(10);
        JPanel jpnumber = new JPanel();
        jpnumber.setBounds(-80, 1, 500, 25);
        JPanel jpname = new JPanel();
        jpname.setBounds(-80, 30, 500, 25);
        JPanel jpage = new JPanel();
        jpage.setBounds(-80, 59, 500, 25);
        JPanel jpsex = new JPanel();
        jpsex.setBounds(-80, 88, 500, 25);
        JPanel jpmath = new JPanel();
        jpmath.setBounds(-85, 117, 500, 25);

        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);

        jpname.add(jlname);
        jpname.add(jtname);

        jpage.add(jlage);
        jpage.add(jtage);

        jpsex.add(jlsex);
        jpsex.add(jtsex);

        jpmath.add(jlmath);
        jpmath.add(jtmath);


        this.setTitle("添加学生信息");
        getContentPane().setLayout(null);
        getContentPane().add(jpnumber);
        getContentPane().add(jpname);
        getContentPane().add(jpage);
        getContentPane().add(jpsex);
        getContentPane().add(jpmath);

        buttonadd.setBounds(15, 224, 160, 21);
        getContentPane().add(buttonadd);
        buttonreturn.setBounds(200, 224, 160, 21);
        getContentPane().add(buttonreturn);

        jlenglish.setBounds(0, 146, 600, 25);
        getContentPane().add(jlenglish);
        getContentPane().add(jtenglish);

        jldata.setBounds(0, 175, 600, 25);
        getContentPane().add(jldata);
        getContentPane().add(jtdata);

        buttonreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
                String USER = "root";
                String PASS = "12345678";

                // Add
                Connection conn = null;
                Statement stat = null;
                PreparedStatement ps = null;
                try {
                    Class.forName(JDBC_DRIVER);

                    // 打开链接
                    System.out.println("连接数据库...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    // 执行查询
                    stat = conn.createStatement();

                    String sql = "INSERT INTO student (sno,name,age,sex,math,english,data) values("
                            +jtnumber.getText()+",\""+jtname.getText()+"\","+jtage.getText()
                            +",\""+jtsex.getText()+"\","+jtmath.getText()+","+jtenglish.getText()+","+jtdata.getText() + ")";

                    System.out.println("MySQL 连接成功!");
                    stat = conn.createStatement();
                    stat.executeUpdate(sql);
                    System.out.println("插入数据成功!");
                    JOptionPane.showMessageDialog(null,"录入成功");

                } catch (SQLException b) {
                    b.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    try {
                        conn.close();
                        System.out.println("MySQL 关闭成功");
                    } catch (SQLException c) {
                        System.out.println("MySQL 关闭失败 ");
                        c.printStackTrace();
                    }
                }
            }
        });
        this.setLocation(400, 300);
        this.setSize(350, 300);
        this.setVisible(true);
    }
}
