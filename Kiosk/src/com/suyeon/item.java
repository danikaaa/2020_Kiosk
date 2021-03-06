package com.suyeon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class item extends JButton {
    public static Object btn;
    private int price;
    private String title;
    private String img;
    private String dirPath = "C:\\Users\\수연\\eclipse-workspace\\Kiosk\\수연이의커피\\";


    //상품(이름,가격)
    public item(String title, int price) {
        this.title = title;
        this.price = price;
        this.img = img;

        ImageIcon icon = new ImageIcon(dirPath + title + ".png");
        Image image = icon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);

        this.setIcon(new ImageIcon(image));
    }

    //getter, setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

}