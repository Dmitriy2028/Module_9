import java.util.Arrays;

public class MyArrayList<E> {

    Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                newCapacity(minCapacity));
    }
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    private Object[] grow() {
        return grow(size + 1);
    }
    public void add(Object value) {
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, 0,
                elementData, 0,
                s);
        elementData[s] = value;
        size = s + 1;
    }

    public void remove(int index) {
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        elementData[size = newSize] = null;
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            elementData[i] = null;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return elementData[index];
    }
    public String ToString(){
        StringBuilder result = new StringBuilder();
        for(Object element: elementData){
            result.append(element + " ");
        }
        return String.valueOf(result.deleteCharAt(result.length()-1));
    }

}
