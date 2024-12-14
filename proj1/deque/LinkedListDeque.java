package deque;

import java.util.Iterator;

public class LinkedListDeque <T> implements Iterable<T>{
    private class List {
        private List prev;
        private T data;
        private List next;
        private List (List p,T i,List n){
            prev = p;
            data = i;
            next = n;
        }
    }
    private List sentinel;
    private int size = 0;

    public LinkedListDeque(){
        sentinel = new List(null , null ,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        List n = new List(sentinel,item,sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;
    }
    public void addLast(T item){
        List n = new List(sentinel.prev,item,sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque(){
        List p = sentinel.next;
        for(int i=0;i<size;i++){
            System.out.print(p.data+" ");
            p=p.next;
        }
    }
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        List p = sentinel.next;
        sentinel.next=p.next;
        p.next.prev=sentinel;
        size--;
        return p.data;
    }
    public T removeLast(){
        if(size == 0){
            return null;
        }
        List p = sentinel.prev;
        sentinel.prev=p.prev;
        p.prev.next=sentinel;
        size--;
        return p.data;
    }
    public T get(int index){
        if(index>=0 && index <=size){
            List p = sentinel.next;
            while(index--!=0){
                p=p.next;
            }
            return p.data;
        }
        return null;
    }
    private class LinkedListDequeIterator implements Iterator<T>{
        private List current;
        public LinkedListDequeIterator (){
            current = sentinel.next;
        }
        @Override
        public boolean hasNext(){
            return current!=sentinel;
        }
        @Override
        public T next(){
            T returnitem = current.data;
            current=current.next;
            return returnitem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if( o instanceof LinkedListDeque){
            LinkedListDeque Lo=(LinkedListDeque)o ;
            if(this.size!=Lo.size){
                return false;
            }
            int index = 0;
            for (T i:this){
                if(i!=Lo.get(index)){
                    return false;
                }
                index++;
            }
            return true;
        }
        return false;
    }
}
