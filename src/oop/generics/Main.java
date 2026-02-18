package oop.generics;

public class Main{


    public static void main(String[] args) {

        Box<String> box = new Box<>("Hello Generyki");

        Box<Integer> intBox = new Box<>(123);

        box.printBox();
        intBox.printBox();



    }
}
