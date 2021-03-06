package com.suyeon;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

// 메인 툴
public class KioskTool extends JFrame implements ActionListener {
    private int result;
    private JTextArea db = new JTextArea(5, 15);  // 장바구니 텍스트필드
    private JTextArea sum= new JTextArea(1, 15);   // 합계텍스트필드
    private String str = "";
    private JScrollPane scroll = new JScrollPane(db, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JButton delete = new JButton("취소");

    public KioskTool() {
        setTitle("SUYOEN_cafe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        JTabbedPane pane = createTabbedPane(); // 탭팬을 생성
        setResizable(false); // 프레임 고정

        //장바구니 & 합계 패널 + 주문버튼
        JPanel pay = new JPanel();
        JPanel shoppingList = new JPanel();
        JLabel list = new JLabel("장바구니");    //장바구니
        JLabel list1 = new JLabel("합계금액");   //합계금액
        JButton b = new JButton("주문");       //주문버튼

        shoppingList.setLayout(null);

        //선언
        shoppingList.add(list);
        shoppingList.add(scroll);
        shoppingList.add(list1);
        shoppingList.add(sum);
        shoppingList.add(b);
        shoppingList.add(delete);

        shoppingList.setVisible(true);
        shoppingList.setPreferredSize(new Dimension(5, 150));
        db.setEditable(false);

        // 위치 사이즈
        list.setBounds(30,15,50,50);
        list1.setBounds(30,86,50,50);
        scroll.setBounds(100,10,200,70); // db
        sum.setBounds(100,101,70,20);
        b.setBounds(240,90,60,40);
        delete.setBounds(180,90,60,40);
        //           x, y, 가로, 높이
        c.add(pane, BorderLayout.CENTER); // 탭팬을 컨텐트팬에 부착
        c.add(shoppingList, BorderLayout.PAGE_END);//장바구니 패널
        setSize(350,640);
        setVisible(true);


        // 취소 버튼
        delete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                db.setText("");
                sum.setText("");
                str = "";
                result = 0;
            }

        });

        // 주문 버튼
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                finish pm = new finish("------------------주문내역-------------------- \n" +
                        db.getText() + "------------------------------------------------------------\n합계금액: " +
                        sum.getText() + "\n\n주문이 완료 되었습니다 :) \n이용해 주셔서 감사합니다.");
                db.setText("");
                sum.setText("");
                str = "";
                result = 0;
            }

        });
    }

    // 탭팬 + 아이템s --------------------------------------------------------------
    private JTabbedPane createTabbedPane() {
        CategoryPanel p = new CategoryPanel();
        p.addItem("아메리카노", 1500);
        p.addItem("자몽허니블랙티", 5000);
        p.addItem("레드에이드", 5000);
        p.addItem("오레오프라페", 5400);


        ArrayList<item> items = p.getItems();
        for(int i = 0; i < items.size(); i++) {
            item it = items.get(i);

            it.addMouseListener(new ClickListener());
        }
        // 커피패널
        CategoryPanel coffee = new CategoryPanel();
        coffee.addItem("아메리카노", 2000);
        coffee.addItem("카페모카", 4200);
        coffee.addItem("카라멜마끼아또", 2800);
        coffee.addItem("돌체라떼", 5800);
        coffee.addItem("카페라떼", 4000);
        coffee.addItem("콜드브루", 6200);

        ArrayList<item> items1 = coffee.getItems();
        for(int i = 0; i < items1.size(); i++) {
            item it = items1.get(i);

            it.addMouseListener(new ClickListener());
        }

        //에이드패널
        CategoryPanel ade = new CategoryPanel();
        ade.addItem("레몬에이드", 5000);
        ade.addItem("라임에이드", 5000);
        ade.addItem("체리에이드", 4800);
        ade.addItem("오렌지에이드", 5000);
        ade.addItem("자몽에이드", 5000);
        ade.addItem("레드에이드", 5200);

        ArrayList<item> items2 = ade.getItems();
        for(int i = 0; i < items2.size(); i++) {
            item it = items2.get(i);

            it.addMouseListener(new ClickListener());
        }
        //프라페패널
        CategoryPanel frappe = new CategoryPanel();
        frappe.addItem("오레오프라페", 5400);
        frappe.addItem("카라멜프라페", 5200);
        frappe.addItem("자바칩프라페", 5400);
        frappe.addItem("말차프라페", 5200);
        frappe.addItem("초콜릿프라페", 5200);
        frappe.addItem("딸기크림프라페", 5800);

        ArrayList<item> items3 = frappe.getItems();
        for(int i = 0; i < items3.size(); i++) {
            item it = items3.get(i);

            it.addMouseListener(new ClickListener());
        }

        //티 패널
        CategoryPanel tea = new CategoryPanel();
        tea.addItem("캐모마일티", 4200);
        tea.addItem("히비스커스티", 4200);
        tea.addItem("피치젤리티", 4800);
        tea.addItem("자몽허니블랙티", 5000);
        tea.addItem("밀크티", 4200);
        tea.addItem("얼그레이티", 4200);

        ArrayList<item> items4 = tea.getItems();
        for(int i = 0; i < items4.size(); i++) {
            item it = items4.get(i);

            it.addMouseListener(new ClickListener());
        }

        JTabbedPane pane = new JTabbedPane(); // pane선언
        pane.addTab("추천메뉴", p); // 추천메뉴 탭
        pane.addTab("COFFEE", coffee); // 커피 탭
        pane.addTab("ADE", ade); // 에이드탭
        pane.addTab("FRAPPE", frappe); // 프라페 탭
        pane.addTab("TEA", tea); // 티 탭

        return pane;
    }
    //--------------------------------------------------------------------------------------
    // 주문완료창
    class finish extends JFrame{
        protected final String CENTER = null;
        private Container f1;
        private JPanel pay;
        private JTextArea db = new JTextArea(15, 20);  // 장바구니 위우잉
        private JTextArea sum = new JTextArea(2, 20);
        private String str = "";
        private JScrollPane scroll = new JScrollPane(db);
        private JButton exit = new JButton("확인");

        public finish(String str) {

            f1 = getContentPane();
            pay = new JPanel();

            setVisible(true);
            db.setEditable(false);
            db.setText(str);
            sum.setEditable(false);
            setTitle("주문완료창");

            JLabel list2 = new JLabel();
            list2.setLayout(new BorderLayout());
            list2.add(new JLabel("주문 내역"), BorderLayout.CENTER);

            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            pay.add(scroll);
            f1.add(pay);
            setSize(250,355);
            pay.add(exit);

            exit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    dispose();
                }
            });
        }

        public void setHorizontalAlignment(String center2) {


        }
    }
    class ClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            item btn = (item)e.getSource();
            str += btn.getTitle() +  " " + btn.getPrice() + "원\n";
            db.setText(str);
            for( int i=0; i < 1; i++) {

                result += Integer.valueOf(btn.getPrice());

            }
            sum.setText(result+"원");
        }

    }

    //메인 함수랄까?
    public static void main(String [] args) {
        new KioskTool();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}