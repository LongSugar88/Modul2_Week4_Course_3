
    public class MyArrayList<E> {
        private int size = 0;
        private final int DEFAUL_CAPACITY = 5;
        private Object element[];

        public MyArrayList(){
            element = new Object[DEFAUL_CAPACITY];
        }
        public MyArrayList(int capacity){
            element = new Object[capacity];
        }
        public void addFirst(E e){
            ensureCapacity();
            for( int i= size; i>0; i--){
                element[i] = element[i-1];
            }
            element[0] = e;
            size++;
        }
        public void add(E e){
            ensureCapacity();
            element[size] = e;
            size++;
        }
        public void set(int index, E e){
            for (int i=size-1; i> index; i--){
                element[i] = element[i-1];
            }
            element[index] = e;
            size++;
        }
        public void remote(int index){
            for( int i= index; i < size-1; i++){
                element[i] = element[i+1];
            }
            element[size-1] = null;
            size--;
        }
        public int size(){
            return size;
        }
        public MyArrayList<E> clone( ){
            MyArrayList<E> clone = new MyArrayList<>();
            clone.element = element;
            clone.size = size;
            return clone;
        }
        public boolean contains(E e){
            boolean isContain = false;
            for( int i=0; i< size; i++){
                if( element[i] == e){
                    return isContain = true;
                }
            }
            return isContain;
        }
        public int indexOf( E e){
            int index = -1;
            for(int i=0; i< size; i++){
                if( element[i] == e){
                    index = i;
                    return index;
                }
            }
            return index;
        }
        public Object get(int index){
            return element[index];
        }
        public void clear(){
            element = (E[])new Object[DEFAUL_CAPACITY];
            size = 0;
        }
        public void ensureCapacity(){
            if( size == element.length){
                int newSize = 2*DEFAUL_CAPACITY;
                Object newList[] = new Object[newSize];
                for( int i=0; i< size; i++){
                    newList[i] = element[i];
                }
                element = newList;
            }
        }
        public void print(){
            for( int i=0; i<size; i++){
                System.out.println(element[i]);
            }
        }

    }

