public class A {
    public static int aInstanceCount=0;
    public static A aInstance;
    public String aInstanceVariable;
    A() {
//Super();
        aInstanceCount++;
        aInstanceVariable="aInstanceVar";
        System.out.println("class A");
        aInstance=this;
    }
}

class B extends A {
    public static int bInstanceCount=0;
    public static B bInstance;
    public String bInstanceVariable;
    B() {
//Super();
        bInstanceCount++;
        bInstanceVariable="bInstanceVar";
        System.out.println("class B");
        bInstance=this;
    }
}

class C extends B {
    public static void main(String args[]) {
        int instanceCount=0;
        C c = new C(); //Parent constructor will get call
        if(A.aInstance!=null){
            instanceCount++;
            System.out.println("Value of aInstanceVariable: "+A.aInstance.aInstanceVariable);

        }
        if(B.bInstance!=null){
            instanceCount++;
            System.out.println("Value of bInstanceVariable: "+B.bInstance.bInstanceVariable);
        }
        A a=A.aInstance;
        B b=B.bInstance;
        System.out.println("bInstanceVariable of B earlier: " + B.bInstance.bInstanceVariable);
        //Now we are changing the bInstanceVariable of c which is inherited from B
        c.bInstanceVariable="bInstance After modified by C";
        System.out.println("bInstanceVariable of B after: " + B.bInstance.bInstanceVariable);
        System.out.println("aInstanceVariable of A earlier: " + A.aInstance.aInstanceVariable);
        //Now we are changing the aInstanceVariable of c which is inherited from A
        c.aInstanceVariable="aInstance After modified by C";
        System.out.println("bInstanceVariable of A after: " + A.aInstance.aInstanceVariable);
    }
}
