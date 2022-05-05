import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.desktop.OpenURIEvent;
import java.awt.event.*;
public class NumberGame implements ActionListener {

    JFrame frame = new JFrame("Number Game");
    JTextField textField;
    JButton[] numbers = new JButton[10];
    final  Font font = new Font("Courier", Font.BOLD, 30);
    JTextField history;
    final JButton resetButton=new JButton("Reset");
    final JButton giveUp=new JButton("Give up");
    final JButton enter=new JButton("\u21B5");
    final JButton backSpace=new JButton("\u232B");
    final Color nonClickable=new Color(199, 199, 199);
    final Color clickable=new Color(255, 255, 255);

    public void resetTextField(){
        textField.setText(" __ __ __ __ ");

    }

    NumberGame() {

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(142, 132, 218));
        frame.setResizable(false);

        textField = new JTextField();
        resetTextField();
        textField.setBounds(75, 35, 240, 55);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setBackground(Color.getHSBColor(277, 47, 100));
        textField.setLayout(new GridLayout(1,4,50,50));
        frame.add(textField);

        history = new JTextField();
        history.setBounds(50, 100, 300, 225);
        history.setFont(font);
        history.setEditable(false);
        history.setBackground(Color.getHSBColor(277, 47, 100));
        frame.add(history);
        resetButton.setBounds(50,510,145,50);
        frame.add(resetButton);
        giveUp.setBounds(205,510,145,50);
        frame.add(giveUp);
        backSpace.setBounds(50,340,145,50);
        frame.add(backSpace);
        enter.setBounds(205,340,145,50);
        frame.add(enter);

        JPanel numberPanel=new JPanel();



        numberPanel = new JPanel();
        numberPanel.setBounds(50, 400, 300, 100);
        numberPanel.setLayout(new GridLayout(2, 5, 10, 10));
        numberPanel.setBackground(new Color(142, 132, 218));

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);

            numberPanel.add(numbers[i]);
        }

        frame.add(numberPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    NumberGame game=new NumberGame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i] && checkAccessible(numbers[i])) {
               textField.setText(textField.getText().concat(String.valueOf(i)
               +"  "));
               setInaccessible(numbers[i]);
            }
        }
        if (e.getSource()==giveUp){
        resetAllButtons();

        }
        if (e.getSource()==resetButton){
            resetTextField();
            resetAllButtons();
        }
        if (e.getSource()==enter){
            resetAllButtons();
            }

        if (e.getSource()==backSpace){

        }



    }
    public void setInaccessible(JButton button){
        button.setForeground(nonClickable);
        button.setEnabled(false);
    }



    public boolean checkAccessible(JButton button){
        if(button.getForeground()!=nonClickable) {
            return true;}
        return false;
    }
    void resetAllButtons(){
        for(int i=0;i<10;i++){
            numbers[i].setEnabled(true);
            numbers[i].setForeground(clickable);
        }
    }
}
