package TD3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Comunica extends JFrame {
    private BufferedWriter writer;
    private BufferedReader reader;
    private JButton bReceiver;
    private JButton bSend;
    private JLabel lmessrec;
    private JLabel lmessend;
    private JTextArea textRec;
    private JTextArea textToSend;

    public Comunica(BufferedWriter writer, BufferedReader reader) {
        this.writer = writer;
        this.reader = reader;
        initComponents();
    }

    private void initComponents(){
        Insets insets = getInsets();

        lmessend = new JLabel("message to send");
        lmessend.setBounds(0+insets.left,25+insets.top,lmessend.getPreferredSize().width,lmessend.getPreferredSize().height);
        add(lmessend);

        textToSend = new JTextArea(15,10);
        JScrollPane jpSend = new JScrollPane(textToSend);
        jpSend.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jpSend.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jpSend);

        bSend=new JButton("send");
        bSend.setBounds(200+insets.left,50+insets.top,bSend.getPreferredSize().width, bSend.getPreferredSize().height);
        bSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message sent : " + textToSend.getText());
            }
        });
        add(bSend);

        bReceiver=new JButton("receive");
        bReceiver.setBounds(0+insets.left,50+insets.top,bReceiver.getPreferredSize().width, bReceiver.getPreferredSize().height);
        bReceiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message received : " + textRec.getText());
            }
        });
        add(bReceiver);

        lmessrec= new JLabel("received message");
        lmessrec.setBounds(0+insets.left,125+insets.top,lmessend.getPreferredSize().width,lmessend.getPreferredSize().height);
        add(lmessrec);

        textRec = new JTextArea(15,10);
        JScrollPane jpRec = new JScrollPane(textRec);
        jpRec.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jpRec.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jpRec);

        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(0,2));
        setVisible(true);
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public JButton getbReceiver() {
        return bReceiver;
    }

    public void setbReceiver(JButton bReceiver) {
        this.bReceiver = bReceiver;
    }

    public JButton getbSend() {
        return bSend;
    }

    public void setbSend(JButton bSend) {
        this.bSend = bSend;
    }

    public JLabel getLmessrec() {
        return lmessrec;
    }

    public void setLmessrec(JLabel lmessrec) {
        this.lmessrec = lmessrec;
    }

    public JLabel getLmessend() {
        return lmessend;
    }

    public void setLmessend(JLabel lmessend) {
        this.lmessend = lmessend;
    }

    public JTextArea getTextRec() {
        return textRec;
    }

    public void setTextRec(JTextArea textRec) {
        this.textRec = textRec;
    }

    public JTextArea getTextToSend() {
        return textToSend;
    }

    public void setTextToSend(JTextArea textToSend) {
        this.textToSend = textToSend;
    }
}
