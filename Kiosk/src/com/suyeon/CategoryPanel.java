package com.suyeon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//상품 상자
public class CategoryPanel extends JPanel {

    private String title;
    ArrayList<item> items = new ArrayList<item>();

    //패널 생성자
    public CategoryPanel() {
        this.setBackground(Color.white);//배경화면 색
    }


    // 상품 이름만
    public void addItem(String title) {
        item i = new item(title, -1);
        items.add(i);
        this.add(i);
    }

    // 상품 이름,가격
    public void addItem(String title, int price) {
        item i = new item(title, price);
        items.add(i);
        this.add(i);
    }

    public ArrayList<item> getItems() {
        return items;
    }
}

