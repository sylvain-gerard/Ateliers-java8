package dma;

@FunctionalInterface
public interface PropositionElement<T> {
  /** retourne true si le premier élément est "meilleur" que le deuxième
   *  retourne false sinon. 
   *  Les classes concrètes qui implémentent cette interface doivent donner 
   *  une définition de estMeilleur
   */
  public boolean estMeilleur(T elem1, T elem2);
}
