package com.projet;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try{

            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){

                if("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        FormAddStudent fd = new FormAddStudent();
        fd.setVisible(true);
    }
}
