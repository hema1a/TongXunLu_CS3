package CS_3_TongXunLu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

class Tongxunlu<Jpanel> {
    private String number;
    private String address;
    private String name;





    JFrame frame;
    JPanel panel1,panel2,panel3;
    JButton button1,button2,button3,button4,button5,button6;
    JTextArea text1,text2,text3,text4,text11,text22,text33,text44;
    JTextArea text111,text222,text333,text444,text1111,text2222,text3333,text4444;
    GridLayout layout=new GridLayout(2,2);


    public void init(){
        frame =new JFrame("个人通讯录");
        button1 =new JButton("添加联系人信息");
        button2 =new JButton("删除联系人信息");
        button3 =new JButton("更改联系人信息");
        button4 =new JButton("查询联系人信息");

        panel1 =new JPanel();
        panel1.setLayout(layout);
        panel1.add(button1,BorderLayout.SOUTH);
        //button1.setBounds(150,300,100,50);
        panel1.add(button2,BorderLayout.NORTH);
        panel1.add(button3,BorderLayout.CENTER);
        panel1.add(button4,BorderLayout.SOUTH);

        frame.add(panel1);
        panel1.setBackground(Color.pink);
        frame.setSize(400,400);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("添加联系人信息")){
                    Tongxunlu u=new Tongxunlu();
                    u.tanchuang();
                }

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("删除联系人信息")){
                    TXL_Dao.TongxunluDao dao=new TXL_Dao.TongxunluDaoImpl();
                    String pname=null;
                    System.out.println("请输入需要删除的人的姓名：");
                    Scanner sc=new Scanner(System.in);
                    pname=sc.nextLine();
                    dao.delete(pname);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("更改联系人信息")){
                    Tongxunlu u=new Tongxunlu();
                    u.genggai();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("查询联系人信息")){

                    TXL_Dao.TongxunluDao dao=new TXL_Dao.TongxunluDaoImpl();
                    List<Tongxunlu> Tongxunlus=dao.findAll();//查询数据-----查
                    for(Tongxunlu s:Tongxunlus){
                        System.out.println(s.getName()+"\t"
                                +s.getNumber()+"\t"
                                +s.getAddress()+"\t"
                        );}
                }
            }
        });
    }

    public void tanchuang(){
        JDialog fm = new JDialog();//构造一个新的JFrame，作为新窗口。
        // 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
        //fm.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        fm.setSize(600,400);// 设置模式类型。
        fm.setVisible(true);

        text11=new JTextArea("Name");
        text1 =new JTextArea(3,30);
        text22=new JTextArea("Number");
        text2 =new JTextArea(3,30);
        text33=new JTextArea("Address");
        text3 =new JTextArea(3,30);

        //text5 =new JTextArea("Age",3,30);

        panel2 =new JPanel();
        button5 =new JButton("添加");

        button6 =new JButton("更改");
        /*FlowLayout layou=new FlowLayout();
        panel2.setLayout(layou);*/
        panel2.add(text1,BorderLayout.SOUTH);
        panel2.add(text11,BorderLayout.SOUTH);
        //button1.setBounds(150,300,100,50);

        panel2.add(text2,BorderLayout.SOUTH);
        panel2.add(text22,BorderLayout.SOUTH);

        panel2.add(text3,BorderLayout.SOUTH);
        panel2.add(text33,BorderLayout.SOUTH);


        //panel2.add(text5,BorderLayout.SOUTH);
        panel2.add(button5,BorderLayout.SOUTH);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("添加")){
                    Tongxunlu u=new Tongxunlu();

                    u.setName(text1.getText());
                    u.setNumber(text2.getText());
                    u.setAddress(text3.getText());
                    TXL_Dao.TongxunluDao dao=new TXL_Dao.TongxunluDaoImpl();
                    dao.add(u);

                }
            }
        });

        //panel2.add(button4,BorderLayout.SOUTH);
        fm.add(panel2);
    }

    public void genggai(){
        JDialog fmr = new JDialog();//构造一个新的JFrame，作为新窗口。
        // 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
        //fm.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        fmr.setSize(600,400);// 设置模式类型。
        fmr.setVisible(true);

        text1111=new JTextArea("Name");
        text111 =new JTextArea(3,30);
        text2222=new JTextArea("Number");
        text222 =new JTextArea(3,30);
        text3333=new JTextArea("Address");
        text333 =new JTextArea(3,30);

        //text5 =new JTextArea("Age",3,30);

        panel3 =new JPanel();

        button6 =new JButton("更改");
        /*FlowLayout layou=new FlowLayout();
        panel2.setLayout(layou);*/
        panel3.add(text111,BorderLayout.SOUTH);
        panel3.add(text1111,BorderLayout.SOUTH);
        //button1.setBounds(150,300,100,50);

        panel3.add(text222,BorderLayout.SOUTH);
        panel3.add(text2222,BorderLayout.SOUTH);

        panel3.add(text333,BorderLayout.SOUTH);
        panel3.add(text3333,BorderLayout.SOUTH);


        //panel2.add(text5,BorderLayout.SOUTH);
        panel3.add(button6,BorderLayout.SOUTH);

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("更改")){
                    Tongxunlu u=new Tongxunlu();
                    u.setName(text111.getText());
                    u.setNumber(text222.getText());
                    u.setAddress(text333.getText());
                    TXL_Dao.TongxunluDao dao=new TXL_Dao.TongxunluDaoImpl();
                    dao.update(name,u);

                }
            }
        });

        fmr.add(panel3);
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String  address) {
        this.address = address;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String  number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
