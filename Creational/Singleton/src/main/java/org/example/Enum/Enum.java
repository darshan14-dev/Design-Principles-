package org.example.Enum;


enum Singleton{
    INSTANCE;

    public void doSomething(){
        System.out.println("doSomething");
    }
}

public class Enum{

    public static void main(String[] args){
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;

        System.out.println(s1 == s2);
    }

}
