package Trees;
        
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0;}
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0;}   
    public boolean isRoot(Position<E> p) { return p == root( ); }
    public boolean isEmpty( ) { return size( ) == 0;} 

    private void subtreePositions(Position<E> p, List<Position<E>> list) 
    {
        list.add(p);
        for(Position<E> c : children(p))
            subtreePositions(c, list);
    }
        
    public Iterable<Position<E>> positions( ) 
    {
        List<Position<E>> list = new ArrayList<>( );
        if (!isEmpty()) 
            subtreePositions(root( ), list);
        return list;
    }
    public Iterator<E> iterator() { return new ElementIterator();}
    
    private class ElementIterator implements Iterator<E> {
        Iterable<Position<E>> snapshot = positions();
        Iterator<Position<E>> posIterator = snapshot.iterator();
        public boolean hasNext() {return posIterator.hasNext();}
        public E next() {return posIterator.next().getElement();}
    }
}