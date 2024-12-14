package deque;

import java.util.Iterator;

public class ArrayDeque <T> implements Iterable <T> {
    T[] data;
    int size =0;
    int space,front,back;
    public ArrayDeque(){
        space = 8;
        front = 0;
        back = 7;
        data= (T[]) new Object [space];
    }
    private void resize(){
        if(size==space){
            T[]tmp = data;
            space *= 2;
            data = (T[]) new Object [space];
            for(int i = 0;front <= space/2-1;i++,front++){
                data[i] = tmp[front];
            }
            for(int i = space/2-1;back >= 0 && back != space/2-1;i--,back--){
                data[i] = tmp[back];
            }
            front = 0;
            back = size - 1;
        }else if(size<0.25 * space && space > 8){
            T[]tmp = data;
            space /= 2;
            data = (T[]) new Object [space];
            if(front < back){
                for(int i = 0;front <= back;i++,front++){
                    data[i] = tmp[front];
                }
            } else {
                int i = 0;
                for(;front < space * 2-1;front++,i++){
                    data[i] = tmp[front];
                }
                for(;back >=0;back--,i++){
                    data[i] = tmp[back];
                }
            }
            front = 0;
            back = size - 1;
        }
    }
    public void addFirst(T item){
        resize();
        size++;
        if(front == 0){
            front = space-1;
        }else{
            front--;
        }
        data[front] = item;
    }
    public void addLast(T item){
        resize();
        size++;
        if(back == space-1){
            back = 0;
        }else{
            back++;
        }
        data[back] = item;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque(){
        if(front > back){
            for(int i = front;i <= space-1;i++) {
                System.out.print(data[i] + " ");
            }
            for(int i = 0;i <= back;i++){
                System.out.print(data[i] + " ");
            }
        } else {
            for(int i = front;i <= back;i++){
                System.out.print(data[i] + " ");
            }
        }
    }
    public T removeFirst(){
        resize();
        size--;
        if(front == space-1){
            front = 0;
            T returndata = data[space-1];
            data[space-1] = null;
            return returndata;
        }else{
            front++;
            T returndata = data[front-1];
            data[front-1] = null;
            return returndata;
        }
    }
    public T removeLast(){
        resize();
        size--;
        if(back == 0){
            back = space - 1;
            T returndata = data[0];
            data[0] = null;
            return returndata;
        }else{
            back--;
            T returndata = data[back + 1];
            data[back + 1] = null;
            return returndata;
        }
    }
    public T get(int index){
        if(index > size){
            return null;
        }
        int n = front + index;
        while(n>space){
            n -= space;
        }
        return data[n];
    }
    private class ArrayDequeIterator implements Iterator<T>{
        int pos = front;
        @Override
        public boolean hasNext(){
            if(front < back){
                return pos - front < size;
            }else{
                if(pos >= front){
                    return pos < space;
                }else{
                    return pos <= back;
                }
            }
        }
        @Override
        public T next(){
            T returnitem =data[pos];
            if(pos == space-1){
                pos = 0;
            }else{
                pos++;
            }
            return returnitem;
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o instanceof ArrayDeque){
            ArrayDeque Ao = (ArrayDeque) o;
            if(this.size != Ao.size){
                return false;
            }
            int index = 0;
            T[] t1 = (T[]) new Object [this.size];
            T[] t2 = (T[]) new Object [this.size];
            for(T i : this){
                t1[index] = i;
            }
            index = 0;
            for(Object i : Ao){
                t2[index] = (T)i;
            }
            for (int i=0;i<this.size - 1;i++){
                if(t1[index] != t2[index]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
