package org.example.Synchronize;

class Singleton{
    private static Singleton instance;
    private Singleton() {}
    synchronized public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}


public class Synchronize {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
