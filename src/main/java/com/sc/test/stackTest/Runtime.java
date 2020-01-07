//package com.sc.test.stackTest;
//
//import java.util.Collection;
//import java.util.IdentityHashMap;
//
//public class Runtime {
//
//    // 钩子对象必须是一个Thread（或其子类）
//    public void addShutdownHook(Thread hook) {
//        // 看起来是个权限检查
//        SecurityManager sm = System.getSecurityManager();
//        if (sm != null) {
//            sm.checkPermission(new RuntimePermission("shutdownHooks"));
//        }
//        // 真正的注册逻辑在这个类里面
//        ApplicationShutdownHooks.add(hook);
//    }
//}
//
//class ApplicationShutdownHooks {
//
//    // 钩子集合
//    private static IdentityHashMap<Thread, Thread> hooks;
//
//    // 注册一个钩子
//    static synchronized void add(Thread hook) {
//        if(hooks == null)
//            throw new IllegalStateException("Shutdown in progress");
//
//        // 看来注册前不能让Thread跑起来
//        if (hook.isAlive())
//            throw new IllegalArgumentException("Hook already running");
//
//        // 同一个钩子不能重复注册
//        if (hooks.containsKey(hook))
//            throw new IllegalArgumentException("Hook previously registered");
//
//        // 放进集合就算注册成功了？继续往下看
//        hooks.put(hook, hook);
//    }
//
//    // 初始化，本来在最前面，为了跟随我的节奏被我移到后面了
//    static {
//        try {
//            // 看来这个类也不是真正实现钩子回调的地方
//            // 又在Shutdown注册了一个“钩子”，通过这个“钩子”来执行用户自定义的钩子
//            Shutdown.class.newInstance().add(1 /* shutdown hook invocation order */,
//                false /* not registered if shutdown in progress */,
//                new Runnable() {
//                    public void run() {
//                        runHooks();
//                    }
//                }
//            );
//            hooks = new IdentityHashMap<>();
//        } catch (IllegalStateException e) {
//            // application shutdown hooks cannot be added if
//            // shutdown is in progress.
//            hooks = null;
//        }
//    }
//
//    // 执行用户钩子的钩子函数
//    static void runHooks() {
//        Collection<Thread> threads;
//        synchronized(ApplicationShutdownHooks.class) {
//            threads = hooks.keySet();
//            hooks = null;
//        }
//
//        for (Thread hook : threads) {
//            hook.start();
//        }
//        for (Thread hook : threads) {
//            while (true) {
//                try {
//                    hook.join();
//                    break;
//                } catch (InterruptedException ignored) {
//                }
//            }
//        }
//    }
//}