package dma;

@FunctionalInterface
public interface PropositionChaine {
  /** retourne true si la première chaîne est "meilleure" que la deuxième
   *  retourne false sinon. 
   *  Les classes concrètes qui implémentent cette interface doivent donner 
   *  une dfinition de estMeilleure
   */
  public boolean estMeilleure(String s1, String s2);
}
