import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Graph{
    JFrame graphics;
    JLabel label;
    JLabel anotherLabel;
    JPanel panel;
    public String print;



    public Graph(String name){
        this.print = name;
        start();
        showEventDemo();

    }

    public void start(){
        graphics = new JFrame("Sort File");
        graphics.setBounds(300,100,850,550);
        graphics.setLayout(new GridLayout(3,1));

        label = new JLabel("",JLabel.CENTER);
        anotherLabel = new JLabel("",JLabel.CENTER);

        anotherLabel.setSize(350,100);
        graphics.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        graphics.add(label);
        graphics.add(panel);
        graphics.add(anotherLabel);
        graphics.setVisible(true);

    }

    public void showEventDemo(){
        ButtonClickListener hello = new ButtonClickListener();
        hello.setString(print);
        hello.setPanel(panel);
        label.setText("Simple Sorting Program");

        JButton start =  new JButton("Start");
        JButton cancel = new JButton("Cancel");


        start.setActionCommand("OK");
        cancel.setActionCommand("Cancel");

        start.addActionListener(hello);
        cancel.addActionListener(hello);

        panel.add(start);
        panel.add(cancel);


        graphics.setVisible(true);




    }

    public class ButtonClickListener implements ActionListener{
       String print;
        JPanel panel;
        public void actionPerformed(ActionEvent e){

            String command = e.getActionCommand();
            if(command.equals("OK")){
                JFileChooser chooseFile = new JFileChooser();
                JTextArea names = new JTextArea(this.print);
                int textFile = chooseFile.showOpenDialog( null);
                if(textFile == JFileChooser.APPROVE_OPTION){
                    chooseFile.getSelectedFile().getName();
                   File hello = chooseFile.getCurrentDirectory();

                        label.add(names);
                } else if(textFile == JFileChooser.CANCEL_OPTION){
                    chooseFile.cancelSelection();
                }
            } else if (command.equals("Cancel")){
                anotherLabel.setText("Cancel Clicked");
                System.exit(0);
            }
        }

        public void setString(String setting){
             print = setting;
        }

        public String getString(){
            return this.print;
        }
        public void setPanel(JPanel panel){
            this.panel = panel;
        }
    }

}

