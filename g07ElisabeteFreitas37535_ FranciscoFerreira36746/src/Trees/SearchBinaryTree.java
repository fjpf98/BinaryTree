package Trees;

public class SearchBinaryTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {
    public Position<E> addRoot(E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public Position<E> addLeft(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public Position<E> addRight(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    public E set(Position<E> p, E e){
        throw new UnsupportedOperationException("Operação não permitida numa ABP");
    }
    
    private int compEN(E e, Node<E> n){return e.compareTo(n.getElement());}
    
    public E put(E e){
        if(isEmpty()){
            super.addRoot(e);
            return null;
        }else return put(root,e);  
    }


    private E put(Node<E> n, E e){
        E res = null;
        if(compEN(e, n) == 0){
            res = n.getElement();
            n.setElement(e);
        }else
            if(compEN(e, n) < 0){
                if(left(n) == null) super.addLeft(n,e);
                else res = put(n.getLeft(), e);
            }else{
                if(right(n) == null) super.addRight(n, e);
                else res = put(n.getRight(), e);
            }
        return res;
    }
    
    
    private Node<E> minNode(Node<E> n){
        if(n.getLeft()==null) return n;
        else return minNode(n.getLeft());
    }
    private E remove(Node<E> n, E e){
        if(n == null) return null;
        else if(compEN(e, n) < 0)return remove(n.getLeft(), e);
        else if(compEN(e, n) > 0)return remove(n.getRight(), e);
        else
            if(numChildren(n) < 2) return super.remove(n);
            else{
                Node<E> min = minNode(n.getRight());
                n.setElement(min.getElement());
                return super.remove(min);
            }
    }
    
    public E remove(E e){
        return remove(root, e);
    }
    
    private Node<E> find(Node<E> n, E e){
        if(n == null) return null;
        else if(compEN(e, n) == 0) return n;
        else if(compEN(e, n) < 0) return find(n.getLeft(), e);
        else return find(n.getRight(), e);
    }
    public Position<E> find(E e) {
        return find(root, e);
    }
    
}
