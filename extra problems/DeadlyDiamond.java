interface A{
    default void show(){
        System.out.println("Method from A");
    }
}
interface B extends A{
    default void show(){
        System.out.println("method from b");
    }
}
interface C extends A{
    default void show(){
        System.out.println("method from c");
    }
}
public class DeadlyDiamond implements B , C{

    @Override
    public void show(){
        B.super.show();
    }
    public static void main(String[] args) {
        DeadlyDiamond object = new DeadlyDiamond();
        object.show();
    }
}
