public class Animal{
    String name;
    int age ;


    // constructor overloading
    Animal(){
        System.err.println("Animal created ");
    }

    Animal(String name){
        this.name = name;
    }

    Animal(String name , int age){
        this.name = name;
        this.age = age;
        System.err.println("Animal created with name and age"+name+" "+age);
    }

    // static method overloading 

    static void eat(){
        System.out.println("Animal is eating");
    }
    static void eat(String food){
        System.out.println("Animal is eating "+food);
    }
    static void eat(String food , int quantity){
        System.out.println("Animal is eating "+quantity+" "+food);
    }


    // non statuc 
    void sleep(){
        System.out.println("Animal is sleeping");
    }
    void sleep(int hours){
        System.out.println("Animal is sleeping for "+hours+" hours");
    }
    void sleep(String place , int hours){
        System.out.println("Animal is sleeping in "+place+" for "+hours+" hours");
    }


    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal("Dog");
        Animal a3 = new Animal("Cat", 5);

        eat();
        eat("meat");
        eat("grass", 2);

        a1.sleep();
        a1.sleep(8);
        a1.sleep("bed", 10);

        a2.sleep();
        a3.sleep(5);
        a3.sleep("couch",4);
    }
}