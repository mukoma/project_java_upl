package com.projet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormAddStudent extends JFrame {

    private JLabel label_insc;
    private JLabel label_nom;
    private JTextField zone_nom;
    private JLabel label_post;
    private JTextField zone_postnom;
    private JButton btn_valider;
    private JButton btn_annuler;
    private JLabel label_prom;
    private JComboBox comboProm;
    private JLabel label_genre;
    private JCheckBox check1;
    private JCheckBox check2;
    private ButtonGroup groupB;
    private JTable jtableData;
    private JButton btn_update;
    private JButton btn_remove;

    public FormAddStudent(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100,700);
        setTitle("Form add student");

        label_insc =new JLabel("Inscription Etu");
        this.getContentPane().setLayout(null);
        this.getContentPane().add(label_insc);
        label_insc.setPreferredSize(new Dimension(100,20));
        label_insc.setBounds(250,30,200,20);
        label_insc.setFont(new Font("Verdana",Font.BOLD,20));
        label_insc.setForeground(new Color(31,79,203));

        label_nom = new JLabel("Nom");
        this.getContentPane().add(label_nom);
        label_nom.setBounds(20,90,50,20);
        label_nom.setFont(new Font("Verdana",Font.BOLD,15));

        zone_nom = new JTextField();
        this.getContentPane().add(zone_nom);
        zone_nom.setBounds(170,90,250,35);

        label_post = new JLabel("PostNom");
        this.getContentPane().add(label_post);
        label_post.setBounds(20,170,100,20);
        label_post.setFont(new Font("Verdana",Font.CENTER_BASELINE,15));

        zone_postnom = new JTextField();
        this.getContentPane().add(zone_postnom);
        zone_postnom.setBounds(170,170,250,35);

        btn_valider = new JButton("Valider");
        this.getContentPane().add(btn_valider);
        btn_valider.setBounds(150,370,150,40);

        btn_annuler = new JButton("Annuler");
        this.getContentPane().add(btn_annuler);
        btn_annuler.setBounds(350,370,150,40);

        label_prom = new JLabel("Promotion");
        label_genre = new JLabel("Genre");
        String [] prom = {"g1","g2","g3"};
        comboProm = new JComboBox(prom);
        check1 = new JCheckBox("M");
        check2 = new JCheckBox("F");
        groupB = new ButtonGroup();
        groupB.add(check1);
        groupB.add(check2);

        getContentPane().add(label_prom);
        label_prom.setBounds(20,230,100,30);
        label_prom.setFont(new Font("Verdana",Font.BOLD,15));

        getContentPane().add(comboProm);
        comboProm.setBounds(170,230,250,40);
        comboProm.setFont(new Font("Verdana",Font.BOLD,15));

        getContentPane().add(label_genre);

        label_genre.setBounds(20,300,100,30);
        label_genre.setFont(new Font("Verdana",Font.BOLD,15));

        getContentPane().add(check1);

        check1.setBounds(170,300,70,40);
        check1.setFont(new Font("Verdana",Font.BOLD,15));

        getContentPane().add(check2);

        check2.setBounds(250,300,70,40);
        check2.setFont(new Font("Verdana",Font.BOLD,15));

        btn_valider.addActionListener((event)->{
            System.out.println("click ok");
            Student st = new Student();
            st.setNom(zone_nom.getText());
            st.setPostnom(zone_postnom.getText());
            st.setPromotion(comboProm.getSelectedItem().toString());
            boolean ch1 = check1.isSelected();
            boolean ch2 = check2.isSelected();
            String genre = "";
            if(ch1){
                genre = "M";
            }
            else if(ch2){
                genre = "F";
            }
            st.setGenre(genre);
            try {
                StudentManager sm = new StudentManager();
                int res = sm.addStudent(st);
                if(res>=0){
                    JOptionPane.showMessageDialog(getContentPane(),"Save sucess");
                    new StudentManager().selectAllStudents(jtableData);
                }
                zone_nom.setText("");
                zone_postnom.setText("");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        DefaultTableModel model = new DefaultTableModel();
        String [] columnName={"Nom","Postnom","Promotion","genre"};
        model.setColumnIdentifiers(columnName);
        String [][] data = {{"museng","kayij","g3","M"}};
        model.setDataVector(data,columnName);
        jtableData = new JTable(model);

        jtableData.setFont(new Font("Verdana",Font.BOLD,15));
        jtableData.setShowGrid(true);
        jtableData.setShowVerticalLines(true);
        jtableData.setShowHorizontalLines(true);
        JScrollPane pane = new JScrollPane(jtableData);

        getContentPane().add(pane);
        pane.setBounds(550,100,450,250);

        btn_update = new JButton("Modifier");
        getContentPane().add(btn_update);
        btn_update.setBounds(650,370,150,40);

        btn_remove = new JButton("Suprimer");
        getContentPane().add(btn_remove);
        btn_remove.setBounds(850,370,150,40);

        new StudentManager().selectAllStudents(jtableData);

    }
}
