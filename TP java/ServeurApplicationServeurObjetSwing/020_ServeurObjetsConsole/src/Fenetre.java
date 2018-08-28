
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener {

    private JPanel panneauFond;
    private JPanel panneauNord;
    private JLabel jLabelNord;
    private JPanel panneauCentre;
    private JTextArea texte;
    private JPanel panneauSud;
    private JButton button;
    private Font font;
    private ImageIcon on;
    private ImageIcon off;
    private boolean action = false;
    private ThreadClient client;
    private String fenetreRequete;

    public Fenetre(String titre) {
        super(titre);
        addWindowListener(new EcouteFenetre());

        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());

        panneauNord = new JPanel();
        panneauNord.setBackground(Color.BLACK);
        jLabelNord = new JLabel("SERVEUR D'OBJETS");
        font = new Font("Arial", Font.BOLD, 30);
        jLabelNord.setForeground(Color.WHITE);

        jLabelNord.setFont(font);
        panneauNord.add("Center", jLabelNord);

        panneauCentre = new JPanel();
        panneauCentre.setBackground(Color.WHITE);
        texte = new JTextArea(8, 45);
        texte.setForeground(Color.BLACK);

        panneauCentre.add(texte);

        on = new ImageIcon("U:\\JAVA\\TPjava\\ServeurApplicationServeurObjetSwing"
                + "\\020_ServeurObjetsConsole\\src\\Image\\green-on.gif");
        off = new ImageIcon("U:\\JAVA\\TPjava\\ServeurApplicationServeurObjetSwing"
                + "\\020_ServeurObjetsConsole\\src\\Image\\green-off.gif");

        panneauSud = new JPanel();
        panneauSud.setBackground(Color.BLACK);
        panneauSud.setLayout(new FlowLayout(FlowLayout.RIGHT));
        button = new JButton("   ON/OFF", off);
        button.setPreferredSize(new Dimension(120, 40));
        button.addActionListener(this);

        panneauSud.add(button);

        panneauFond.add(panneauNord, BorderLayout.NORTH);
        panneauFond.add(panneauCentre);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);

        add(panneauFond);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            if (action == false) {
                button.setIcon(on);
                action = true;
                ControleurServeur.demarrerServeur();

            } else {
                button.setIcon(off);
                action = false;                
                ControleurServeur.arreterServeur();
            }
        }
    }

    void afficheFenetre(String s) {
        texte.append(s);
    }
}
