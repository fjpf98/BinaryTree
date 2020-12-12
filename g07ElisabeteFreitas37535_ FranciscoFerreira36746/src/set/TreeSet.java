package set;

import Trees.SearchBinaryTree;
import java.util.Iterator;
import java.util.Comparator;


public class TreeSet<E extends Comparable<E>> implements SortedSet<E> {
    private SearchBinaryTree<E> colecao;
    private ComparadorEs comp = new ComparadorEs();
    public TreeSet() {
        colecao = new SearchBinaryTree<>(); 
    }

    private class ComparadorEs implements Comparator<E>{
        public int compare(E e,  E e2)
            {return e.compareTo(e2);}
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        TreeSet subS = new TreeSet();
        for(E e : colecao){
            if(comp.compare(e, fromElement) > 0 && comp.compare(e, toElement) < 0) {
                subS.add(e);
            }   
        }
        System.out.println("SubSet criado com sucesso! \nCom os elementos do Set original, maiores do que  " + fromElement + " e menores do que  " + toElement);
        System.out.println("---->  " + subS.toString());
        return subS;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        TreeSet headS = new TreeSet();
        for(E e : colecao){
            if(comp.compare(e, toElement) < 0) {
                headS.add(e);
            }   
        }
        System.out.println("SubSet criado com sucesso! \nCom os elementos da Tree original menores do que  " + toElement);
        System.out.println("---->  " + headS.toString());
        return headS;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        TreeSet tailS = new TreeSet();
        for(E e : colecao){
            if(comp.compare(e, fromElement) > 0) {
                tailS.add(e);
            }   
        }
        System.out.println("SubSet criado com sucesso! \nCom os elementos da Tree original maiores do que  " + fromElement);
        System.out.println("---->  " + tailS.toString());
        return tailS;
    }

    @Override
    public E min() {
        E min = null;
        for (E e : colecao) 
        { 
            if (min == null) min = e;
            else{
                if(comp.compare(e, min)<0) min = e;
            }
        }
        return min;
    }

    @Override
    public E max() {
        E max = null;
        for (E e : colecao) 
        { 
            if (max == null) max = e;
            else{
                if(comp.compare(e, max)>0) max = e;
            }
        }
        return max; 
    }

    @Override
    public int size() {
        return colecao.size();
    }

    @Override
    public boolean isEmpty() {
        if(colecao.size() == 0) return true;
        else return false;
    }

    @Override
    public boolean contains(E e) {
        if (colecao.find(e) != null) {   
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean add(E e) {

        if (colecao.put(e) != null) return true;
        else return false;
        
    }

    @Override
    public boolean remove(E e) {
        if(isEmpty()) {
            System.out.println("Coleçao vazia! ");
            return false;
        }else {
            colecao.remove(e);
            System.out.println("Elemento removido: " + e);
            return true;
        }
    }

    @Override
    public boolean containsAll(SortedSet<E> s) {
        for(E e : s){
            if(contains(e) == false) return false;
        }
        System.out.println("Todos elementos contidos na coleçao! ");
        return true;
    }

    @Override
    public void addAll(SortedSet<E> s) {
        for(E e : s){
            add(e);
        }
    }

    @Override
    public void removeAll(SortedSet<E> s) {
        for(E e : s){
            remove(e);
        }
    }

    @Override
    public void retainAll(SortedSet<E> s) {
        for(E e : colecao){
            if (s.contains(e) == false) remove(e);  
        }
    }

    @Override
    public void clear(){ 
        for(E e : colecao){
            remove(e);
        }
    }

    @Override
    public SortedSet<E> clone(){
        SortedSet<E> clone = new TreeSet<>();
        Iterator<E> it = colecao.iterator();
        E objecto;

        while (it.hasNext()) {
            objecto = it.next();
            clone.add(objecto);
        }
        return clone;
    }

    @Override
    public Iterator<E> iterator() {
        return colecao.iterator();
    }
    
    public boolean equals(Object obj){
         
        if (obj == null || this.getClass() != obj.getClass()) return false;
        else return colecao == ((TreeSet) obj).colecao;
    }
    
    public String toString(){
        
        Iterator<E> it = colecao.iterator();
        String string = "";
        int tamanho = colecao.size();
        int i;

        for (i = 0; i < tamanho; i++) {
            string += it.next().toString() + ',' + ' ';
        }
        return '[' + string + ']';
     }
     

}