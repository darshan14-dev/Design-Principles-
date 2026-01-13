package org.example.LazyInitialization;

 class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance(){
        if(instance == null){


            instance = new Singleton();
        }
        return instance;
    }
}

public class LazyInitialization{
     static void main(){
       Singleton singleton1 = Singleton.getInstance();
       Singleton singleton2 = Singleton.getInstance();
       Singleton singleton3 = Singleton.getInstance();

       System.out.println(singleton1 == singleton2);
   }

}
