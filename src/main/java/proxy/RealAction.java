package proxy;

public class RealAction implements Action {

    public void doSomething() {
        System.out.println("接口调用");
    }
}
