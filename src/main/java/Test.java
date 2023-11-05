// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Test {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        System.out.println(myArrayList.ToString());
        myArrayList.remove(1);
        System.out.println(myArrayList.ToString());
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(1).toString());
        myArrayList.clear();
        System.out.println(myArrayList.ToString());


        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(5);
        myLinkedList.remove(2);


        MyQueue myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.peek();
        myQueue.poll();
        myQueue.size();
        myQueue.clear();


        MyStack myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.peek();
        myStack.pop();
        myStack.size();
        myStack.clear();


        MyHashMap myHashMap = new MyHashMap<>();
        myHashMap.put("A",1);
        myHashMap.put("B",2);
        myHashMap.put("C",3);
        myHashMap.put("D",4);
        myHashMap.put("E",5);
        myHashMap.put("F",6);
        myHashMap.put("G",6);
        myHashMap.put("H",6);
        myHashMap.put("K",6);//
        myHashMap.put("L",6);
        myHashMap.put("M",6);
        myHashMap.remove("K");
        myHashMap.Size();
        myHashMap.clear();
    }
}