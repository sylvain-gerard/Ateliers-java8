package dma;

@FunctionalInterface
public interface PropositionElement<T> {
  /** retourne true si le premier �l�ment est "meilleur" que le deuxi�me
   *  retourne false sinon. 
   *  Les classes concr�tes qui impl�mentent cette interface doivent donner 
   *  une d�finition de estMeilleur
   */
  public boolean estMeilleur(T elem1, T elem2);
}
