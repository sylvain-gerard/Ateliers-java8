package dma;

import java.awt.Color;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LecteurImages extends JFrame {
  private static final long serialVersionUID = 1L;
  private final JPanel imagePanel;
  private final String imagePattern = "file:Images/poisson%s.jpg";
  private final int numImages = 10;
  
  /* poolSize: la taille du pool de threads */
  public LecteurImages(int poolSize) throws Exception {
    super("Some Internet Cafes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setNimbusLaf();
    imagePanel = new JPanel();
    imagePanel.setBackground(Color.LIGHT_GRAY);
    JScrollPane contentPane = new JScrollPane(imagePanel);
    setContentPane(contentPane);
    ExecutorService taskList = Executors.newFixedThreadPool(poolSize);
    long before = System.currentTimeMillis();
    for(int i=1; i<=numImages; i++) {
      JLabel label = new JLabel();
      URL location = new URL(String.format(imagePattern, i));
      
//      taskList.execute(new Runnable(){
//    	  @Override
//    	  public void run(){
//    		  ImageIcon icon = new ImageIcon(location);
//    	      label.setIcon(icon);
//    	  }
//      });
      taskList.execute(() -> label.setIcon(new ImageIcon(location)));
      imagePanel.add(label);
      System.out.println(" image " + i + " récupée");
    }
    taskList.shutdown();
    taskList.awaitTermination(60, TimeUnit.SECONDS);
    long after = System.currentTimeMillis();
    System.out.println("durée totale pour afficher toutes les images = " + (after-before));
    setSize(640, 475);
    setVisible(true);
  }
  
  private static void setNimbusLaf() {
		try {
		  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
  }
}
