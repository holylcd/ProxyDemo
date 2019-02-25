package proxy;

public class StaticProxyAction implements Action {

    private Action action;

    public StaticProxyAction(Action action){
        this.action = action;
    }

    public void doSomething() {

        //代理切入
        System.out.println("切入日志");

        // 代理执行
        action.doSomething();
    }


    /**
     * 静态代理的缺陷
     * 1. 一个代理只能实现一类对象
     * 2. 一个需要被代理的业务需要一个代理类（realAction+StaticProxyAction），代码膨胀
     */
}
