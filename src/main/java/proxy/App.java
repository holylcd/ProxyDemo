package proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class App extends Thread {

    public static void main(String[] args) {

        // static proxy
//        Action realAction = new RealAction();
//        Action action = new StaticProxyAction(realAction);
//        action.doSomething();
//
//
//        // dynamic proxy
//        Action realAction1 = new RealAction();
//        DynamicProxy dynamicProxy = new DynamicProxy();
//        Action realAction2 = (Action) dynamicProxy.bind(realAction1);
//        realAction2.doSomething();
//
//        // 查看动态生成的类
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0"
//                , RealAction.class.getInterfaces());
//        String path = "DynamicProxy.class";
//
//        // java7提供的一种方法，不需要我们关心流的关闭
//        try(FileOutputStream fos = new FileOutputStream(path)){
//            fos.write(classFile);
//            fos.flush();
//        }catch (Exception e){
//        }



        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"code");

        // cglib static proxy
        RealAction realAction3 = new RealAction();
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        RealAction realAction4 = (RealAction) cglibDynamicProxy.getInstance(realAction3);
        realAction4.doSomething();


    }

}
