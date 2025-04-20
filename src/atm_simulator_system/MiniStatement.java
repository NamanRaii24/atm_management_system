package atm_simulator_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

  
    
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 400);
        add(mini);

        JLabel bank = new JLabel("NMN BANK");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 110, 320, 20); // Moved just below card label
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            double bal = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder("<html>");

            while (rs.next()) {
                statement.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;Rs ")
                        .append(rs.getString("amount"))
                        .append("<br><br>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Double.parseDouble(rs.getString("amount"));
                } else {
                    bal -= Double.parseDouble(rs.getString("amount"));
                }
            }

            statement.append("</html>");
            mini.setText(statement.toString());
            balance.setText("Current Balance:Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("2424");
    }
}
