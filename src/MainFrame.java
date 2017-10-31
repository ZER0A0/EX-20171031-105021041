import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame{
    public MainFrame(LoginFrame LF){
        loginFrame = LF;
        initComp();
    }
    private LoginFrame loginFrame;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmS = new JMenu("Set");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmA = new JMenu("About");
    private JMenuItem jmiFBO = new JMenuItem("Book");
    private JMenuItem jmiFEX = new JMenuItem("Exit");
    private JMenuItem jmiSF = new JMenuItem("Font");
    private JMenuItem jmiGLT = new JMenuItem("LoTo");
    private JDesktopPane jdp = new JDesktopPane();
    private int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private String jlbF[] = new String[]{"PLAIN" , "BOLD" , "ITALIL" , "BOLD + ITALIL"};
    //private JComboBox jcb = new JComboBox(Option);

    private JInternalFrame jif = new JInternalFrame();
    private Container jifCP;
    private JPanel jpn = new JPanel(new GridLayout(1 , 6 , 5 , 5));
    private JPanel jpnB = new JPanel(new GridLayout(1 , 2 , 5 , 5));
    private JButton jbtEX = new JButton("Exit");
    private JButton jbtRE = new JButton("Replay");
    private JLabel jlb[] = new JLabel[6];
    private int data[] = new int[6];
    private Random ran = new Random(System.currentTimeMillis());

    private JInternalFrame jifI = new JInternalFrame();
    private Container jifICP;
    private JMenuBar jmbI = new JMenuBar();
    private JMenu jmIF = new JMenu("File");
    private JMenuItem jmiINE = new JMenuItem("New");
    private JMenuItem jmiILO = new JMenuItem("Load");
    private JMenuItem jmiIEX = new JMenuItem("Exit");
    private JTextField jtfI = new JTextField();

    private void initComp(){
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 - 100 , fw , fh);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jif.setBounds(0 , 0 , 240 , 80);
        this.setContentPane(jdp);
        this.setJMenuBar(jmb);
        jmb.add(jmF);
        jmb.add(jmS);
        jmb.add(jmG);
        jmb.add(jmA);
        jmG.add(jmiGLT);
        jmS.add(jmiSF);
        jmF.add(jmiFBO);
        jmF.add(jmiFEX);

        jdp.add(jif);
        jdp.add(jifI);
        jifCP = jif.getContentPane();
        jifCP.setLayout(new GridLayout(2 , 1 , 1, 1));
        jifCP.add(jpn);
        jifCP.add(jpnB);
        jpnB.add(jbtRE);
        jpnB.add(jbtEX);

        jifI.setBounds(0 , 0 , 500 , 500);
        jifI.setJMenuBar(jmbI);
        jmbI.add(jmIF);
        jmIF.add(jmiINE);
        jmIF.add(jmiILO);
        jmIF.add(jmiIEX);
        jifICP = jifI.getContentPane();
        jifICP.add(jtfI);

        jmiFBO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jifI.setVisible(true);
            }
        });
        jmiFEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jmiGLT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jif.setVisible(true);
            }
        });
        jbtRE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                while (x < 6){
                    data[x] = ran.nextInt(42) + 1;
                    //int y = 0;
                    //boolean flag = true;
                    //while (y < x && flag) {
                    //    if(data[x] == data[y]){flag = false ; data[x] = ran.nextInt(42) + 1;}}
                    jlb[x] = new JLabel("");
                    jlb[x] = new JLabel(Integer.toString(data[x]));
                    jpn.add(jlb[x]);
                    x ++;}}
        });
        jbtEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jif.setVisible(false);
            }
        });

        jmiIEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jifI.setVisible(false);
            }
        });

        jmiFEX.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiGLT.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }
}