public class Test{
    static NeWTest newObj ;
    static  void func(NeWTest obj){
        obj.x = 30;
        obj = new NeWTest();
        obj.x = 40;
        System.out.println("func : "+obj.x);

    }
    public static void main(String[] args) {
        newObj = new NeWTest();
        newObj.x = 20;
        func(newObj);
        System.out.println("main : "+ newObj.x);
    }
}

class NeWTest{
    int x = 10;
}