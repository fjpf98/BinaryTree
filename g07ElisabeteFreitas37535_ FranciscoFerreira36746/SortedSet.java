/*
 * Interface a ser usada no segundo trabalho prático de AED.
 */
package set;

/**
 * Interface para coleções ordenadas com o comportameto típico de conjuntos de elementos (set).
 * Requer que os elementos a colecionar sejam comparáveis.
 * Trata-se de uma versão adaptada da interface
 * <a href="http://docs.oracle.com/javase/7/docs/api/java/util/SortedSet.html">SortedSet</a>
 * do package java.util do Java Standard Ed.7.
 * @author Paulo Gouveia
 * @param <E> tipo de elementos a colecionar.
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/">Java™ Platform, Standard Edition 7 API Specification</a>
 * @since 07/06/2020
 */
public interface SortedSet<E extends Comparable<E>> extends Iterable<E>{ 
    
    /**
     * Devolve um subconjunto deste set com os elementos contidos no intervalo [fromElement, toElement[.
     * Dito doutra forma, devolve todos os elementos que sejam superiores ou iguais a fromElement
     * e estritamente inferiores a toElement. 
     * @param fromElement limite inferior (inclusivo) dos valores contidos no subconjunto a devolver.
     * @param toElement limite superior (exclusivo) dos valores contidos no subconjunto a devolver.
     * @return set com os elementos deste set superiores ou iguais a fromElement e inferiores a toElement.
     */
    SortedSet<E> subSet(E fromElement, E toElement);
    
    /**
     * Devolve um subconjunto deste set com todos os elementos que sejam estritamente inferiores a toElement.
     * @param toElement limite superior (exclusivo) dos valores contidos no subconjunto a devolver.
     * @return set com os elementos deste set inferiores a toElement.
     */
    SortedSet<E> headSet(E toElement);

    /**
     * Devolve um subconjunto deste set com todos os elementos que sejam superiores ou iguais a fromElement.
     * @param fromElement limite inferior (inclusivo) dos valores contidos no subconjunto a devolver.
     * @return set com os elementos deste set superiores ou iguais a fromElement.
     */
    SortedSet<E> tailSet(E fromElement);
    
    /**
     * Devolve, sem remover, o menor dos elementos.
     * @return o menor elemento deste set.
     */  
    E min();
    
    /**
     * Devolve, sem remover, o maior dos elementos.
     * @return o maior elemento deste set.
     */  
    E max();
    
    /**
     * Devolve a quantidade de elementos contidos neste set.
     * @return número de elementos deste set.
     */
    int size();
    
    /**
     * Verifica se este set não contém elementos.
     * @return true se este set está vazio.
     */
    boolean isEmpty();
    
    /**
     * Verifica se este set contém o elemento específico.
     * @param e elemento cuja presença no set é verificada.
     * @return true se o elemento específico está presente neste set.
     */
    boolean contains(E e);
    
    /**
     * Adiciona o elemento específico a este set se o mesmo ainda não estiver presente.
     * @param e elemento a adicionar a este set.
     * @return true se este set ainda não contiver o elemento específico.
     */
    boolean add(E e);
    
    /**
     * Remove deste set o elemento específico, caso esteja presente.
     * @param e elemento a ser removido deste set.
     * @return true caso o elemento tenha sido removido.
     */
    boolean remove(E e);
    
    /**
     * Verifica se este set contém todos os elementos do set específico.
     * @param s set a verifcar se está contido neste set.
     * @return true se este set contiver todos os elementos do set específico.
     */
    boolean containsAll(SortedSet<E> s);
    
    /**
     * Adiciona neste set todos os elementos contidos no set específico, sem clonar os objetos copiados.
     * @param s set com os elementos a serem adicionados a este set.
     */
    void addAll(SortedSet<E> s);
    
    /**
     * Remove deste set todos os elementos que estejam contidos no set específico.
     * @param s set com os elementos a serem removidos deste set.
     */
    void removeAll(SortedSet<E> s);
    
    /**
     * Remove deste set todos os elementos que não estejam contidos no set específico.
     * @param s set com os elementos a serem retidos neste set.
     */
    void retainAll(SortedSet<E> s);
    
    /**
     * Remove todos os elementos deste set, deixando-o vazio.
     */
    void clear();
    
    /**
     * Devolve uma string com uma representação de todos os elementos colecionados.
     * @return uma string com uma representação dos elementos colecionados.
     */ 
    String toString();
    
    /**
     * Verifica se o objeto específico é considerado igual a este set.
     * @param obj objeto a ser comparado com o set atual.
     * @return true se os sets forem considerados iguais.
     */ 
    boolean equals(Object obj);
    
    /**
     * Devolve uma cópia desta coleção, sem clonar os objetos colecionados.
     * @return um set com os mesmos elementos deste set.
     */ 
    SortedSet<E> clone();
}
 