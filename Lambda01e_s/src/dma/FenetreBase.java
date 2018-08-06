package dma;


import java.awt.*;

import javax.swing.*;

public abstract class FenetreBase extends JFrame {
  private static final long serialVersionUID = 1L;
  protected Container contentPane;
  protected JButton button1, button2, button3;
  
  public FenetreBase(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setNimbusLaf();
    setSize(400, 300);
    contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());
    contentPane.setBackground(Color.LIGHT_GRAY);
    button1 = new JButton("Bleu");
    contentPane.add(button1);
    button2 = new JButton("Vert");
    contentPane.add(button2);
    button3 = new JButton("Rouge");
    contentPane.add(button3);
  }
  
  protected void setBg(Color bgColor) {
    contentPane.setBackground(bgColor);
  }
  
  public static void setNimbusLaf() {
	try {
	  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
  }
}
