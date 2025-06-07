package com.pablo.autogest;

import com.formdev.flatlaf.FlatDarkLaf;
import com.pablo.autogest.VIEW.telaOficina;
import javax.swing.UIManager;


public class AutoGest {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaOficina tela = new telaOficina();
                tela.setTitle("Oficina");
                tela.setVisible(true);
            }
        });
    }
}
