
package Principal;

import set.TreeSet;


public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add(5);
        t.add(2);
        t.add(6);
        t.add(3);
        t.add(4);
        System.out.println("Tree com " + t.size() + " elementos") ;
        
        t.contains(3);
        t.contains(9);
        
        System.out.println(t.toString());
        
        t.remove(2);
        
        System.out.println(t.toString());
        
        t.subSet(3, 6);
        t.tailSet(5);
        t.headSet(4);
        
        System.out.println("O menor elemento na arvore é o: " + t.min());
        System.out.println("O maior elemento na arvore é o: " + t.max());
        
        
        t.addAll(t.headSet(4));
        t.retainAll(t.tailSet(2));
        t.removeAll(t.subSet(3, 5));
        
    }
    
}
