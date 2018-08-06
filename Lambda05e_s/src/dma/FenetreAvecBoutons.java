package dma;

import java.awt.*;

public class FenetreAvecBoutons extends FenetreBase {
  private static final long serialVersionUID = 1L;

  public FenetreAvecBoutons() {
    super("Lamdas");
    button1.addActionListener(event -> contentPane.setBackground(Color.BLUE));
    Color couleurVerte = Color.GREEN;
    button2.addActionListener(event -> setBg(couleurVerte));
    button3.addActionListener(event -> setBg(Color.RED));
    //couleurVerte = Color.GREEN;
    setVisible(true);
  } 
}
