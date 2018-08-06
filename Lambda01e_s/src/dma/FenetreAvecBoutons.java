package dma;

import java.awt.*;
import java.awt.event.ActionEvent;

public class FenetreAvecBoutons extends FenetreBase {
  private static final long serialVersionUID = 1L;

  public FenetreAvecBoutons() {
    super("Lamdas");
 
    button1.addActionListener((ActionEvent event) -> {setBg(Color.BLUE);});
    button2.addActionListener(event -> setBg(Color.GREEN));
    button3.addActionListener(event -> setBg(Color.RED));
    
    setVisible(true);
  } 
}
