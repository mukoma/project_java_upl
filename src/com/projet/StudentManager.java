package com.projet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class StudentManager {

    public int addStudent(Student student) throws SQLException {

        Statement st = ConnexionDb.getInstance().getConnection().createStatement();
        String req = "INSERT INTO etudiant(nom,postnom,promotion,genre) VALUES('"+student.getNom()+"','"+student.getPostnom()+"','"+student.getPromotion()+"','"+student.getGenre()+"')";
        return st.executeUpdate(req);
    }
    public void selectAllStudents(JTable table) {

        Vector data = new Vector();
        try {

            Statement st = ConnexionDb.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM etudiant";
            ResultSet res =  st.executeQuery(req);
            ResultSetMetaData metaData = res.getMetaData();
            int columns = metaData.getColumnCount();
            while (res.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(res.getObject(i));
                }
                data.addElement(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Vector columnNames = new Vector();
        columnNames.addElement("name");
        columnNames.addElement("postnom");
        columnNames.addElement("promotion");
        columnNames.addElement("genre");

        DefaultTableModel dm;
        dm=(DefaultTableModel) table.getModel();
        dm.setDataVector(data,columnNames);

        table.setModel(dm);
    }
}
