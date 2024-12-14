package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque{
    Comparator<T> sc;
    public MaxArrayDeque(Comparator<T> c){
        super();
        sc = c;
    }
    public T max(){
        if(this==null){
            return null;
        }
        int s = this.size();
        T Max = (T) this.get(0);
        for(int i=1;i<size;i++){
            if(sc.compare(Max, (T) get(i)) < 0){
                Max = (T) get(i);
            }
        }
        return Max;
    }
    public T max(Comparator<T> c){
        if(this==null){
            return null;
        }
        int s = this.size();
        T Max = (T) this.get(0);
        for(int i=1;i<size;i++){
            if(c.compare(Max, (T) get(i)) < 0){
                Max = (T) get(i);
            }
        }
        return Max;
    }
    @Override
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
            for(Object i : this){
                t1[index] = (T) i;
            }
            index = 0;
            for(Object i : Ao){
                t2[index] = (T)i;
            }
            for (int i=0;i<this.size - 1;i++){
                if(sc.compare(t1[i],t2[i]) != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
