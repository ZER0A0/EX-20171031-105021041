import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    public LoginFrame(){
        initComp();
    }
    private Container cp;
    private JLabel jlbID = new JLabel("ID:");
    private JLabel jlbPW = new JLabel("Password:");
    private JTextField jtfID = new JTextField("OAO");
    private JPasswordField jpf = new JPasswordField("33433");
    private JButton jbtEX = new JButton("Exit");
    private JButton jbtLG = new JButton("Login");
    private int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fw = 300 , fh = 150;
    private void initComp(){
        this.setBounds(sw / 2 - fw / 2 ,sh / 2 - fh / 2 - 100 , fw , fh);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        jlbID.setHorizontalAlignment(JLabel.RIGHT);
        jlbPW.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(jlbID);
        cp.add(jtfID);
        cp.add(jlbPW);
        cp.add(jpf);
        cp.add(jbtEX);
        cp.add(jbtLG);
        jbtEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtLG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtfID.getText().equals("OAO") && new String(jpf.getPassword()).equals("33433")){
                    MainFrame MF = new MainFrame(LoginFrame.this);
                    MF.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }
}