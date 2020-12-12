package Trees;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> 
{   

    protected static class Node<E>  implements Position<E>{
        private E element; 
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild)
        {
            element= e;
            parent= above;
            left= leftChild;
            right= rightChild;
        }
        
        public E getElement( ) { return element; }
        public Node<E> getParent( ) { return parent;} 
        public Node<E> getLeft( ) { return left; }
        public Node<E> getRight( ) { return right;} 
        public void setElement(E e) { element= e; }
        public void setParent(Node<E> parentNode) { parent= parentNode;}
        public void setLeft(Node<E> leftChild) { left= leftChild;}
        public void setRight(Node<E> rightChild) { right= rightChild;}
    }
    
    protected Node<E> root= null;
    private int size= 0;
    
    protected Node<E> node(Position<E> p){
        if (!(p instanceof Node))throw new IllegalArgumentException("Tipo de posição inválido!");
    return(Node<E>) p;
    }
    
    public int size(){return size;}
    public Position<E> root(){return root;}
    public Position<E> parent(Position<E> p) {return node(p).getParent();}
    public Position<E> left(Position<E> p) {return node(p).getLeft();}
    public Position<E> right(Position<E> p) {return node(p).getRight();}
    
    
    public Position<E> addRoot(E e){
        if(!isEmpty()) return null;
        root = new Node<E>(e, null, null, null);
        size = 1;
        return root;
    }
    
    public Position<E> addLeft(Position<E> p, E e){
        Node<E> n = node(p);
        if(n.getLeft() != null) return null;
        Node<E> child = new Node<E>(e, n, null, null);
        n.setLeft(child);
        size++;
        return child;
    }
    
    
    public Position<E> addRight(Position<E> p, E e){
        Node<E> n = node(p);
        if(n.getRight() != null) return null;
        Node<E> child = new Node<E>(e, n, null, null);
        n.setRight(child);
        size++;
        return child;
    }
    
    public E set(Position<E> p, E e){
        Node<E> n = node(p);
        E temp = n.getElement();
        n.setElement(e);
        return temp;
    }

    
    public E remove(Position<E> p){
        if(numChildren(p) == 2) return null;
        Node<E> n = node(p);
        Node<E> parent = n.getParent();
        Node<E> child =  (n.getLeft() != null ? n.getLeft() : n.getRight());
        if(child != null) child.setParent(parent);
        if(n == root) root = child;
        else
            if (n == parent.getLeft()) parent.setLeft(child);
            else parent.setRight(child);
        size--;
        E temp = n.getElement();
        n.setElement(null);
        n.setLeft(null);
        n.setRight(null);
        n.setParent(null);
        return temp;
    }
}
