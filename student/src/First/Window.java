package First;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window frame = new Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Window() {
        setTitle("学生信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("\u4FE1\u606F\u5F55\u5165");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Add f = new Add();
                f.setSize(400, 300);
                JLabel label = new JLabel("我是新窗口");
                f.add(label);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
        btnNewButton.setBounds(120, 300, 200, 40);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u4FE1\u606F\u5220\u9664");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Delete f = new Delete();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(480, 300, 200, 40);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u67E5\u627E");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ask f = new Ask();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
        btnNewButton_2.setBounds(120, 370, 200, 40);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u6D4F\u89C8");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				Look f = new Look();
	            f.setLocationRelativeTo(null);
	            f.setVisible(true);
            }
        });
        btnNewButton_3.setBounds(480, 370, 200, 40);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("\u4FE1\u606F\u4FEE\u6539");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Change f = new Change();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
        btnNewButton_4.setBounds(120, 440, 200, 40);
        contentPane.add(btnNewButton_4);

        ImageIcon background = new ImageIcon(Window.class.getResource("dut800.jpg"));
        background.setImage(background.getImage().getScaledInstance(background.getIconWidth(),background.getIconHeight(), Image.SCALE_DEFAULT));
        JLabel lb = new JLabel();
        lb.setBounds(0, 0, 800, 300);
        lb.setIcon(background);
        contentPane.add(lb);
    }

}