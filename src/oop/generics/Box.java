package oop.generics;

public class Box <T>{
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void printBox(){
        System.out.println("Box contains: " + value);
    }
}
