package com.ittest.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {
    public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception {
        String methodStr = "";
        Method[] methods = infce.getMethods();
        /*for (Method method : methods) {
//            System.out.println(method.getName());
            methodStr += "@Override\n" +
                    "public void " + method.getName() + "(){\n" +
                    "        long start = System.currentTimeMillis();\n" +
                    "        System.out.println(\"starttime:\"+start);\n" +
                    "        t."+method.getName()+ "();\n" +
                    "        long end = System.currentTimeMillis();\n" +
                    "        System.out.println(\"time:\"+(end-start));\n" +
                    "    }\n";
        }*/
        for (Method method : methods) {
//            System.out.println(method.getName());
            methodStr += "@Override\n" +
                    "public void " + method.getName() + "(){\n" +
                    "   try{\n" +
                    "   Method md= " + infce.getName() + ".class.getMethod(\"" + method.getName() + "\");\n" +
                    "   h.invoke(this,md);\n" +
                    "   }catch(Exception e){e.printStackTrace();}\n" +
                    "    }\n";
        }
        String src =
                "package com.ittest.proxy;\n" +
                        "\n" +
                        "import java.lang.reflect.Method;\n"+
                        "public class $Proxy1 implements " + infce.getName() + "{\n" +
                        "\n" +
                        "   com.ittest.proxy.InvocationHandler h;\n"+
                        "    public $Proxy1(InvocationHandler h) {\n" +
                        "        this.h = h;\n" +
                        "    }\n" +
                        "\n" +
                        methodStr+
                        "}\n";
        String fileName =
                 "/Users/yangxin/test/src/com/ittest/proxy/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();
        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        t.call();
        fileManager.close();

        //load into memory and create instance
        URL[] urls = new URL[]{new URL("file:/" + "Users/yangxin/test" + "/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
//        System.out.println(ul.getURLs());
        Class c = ul.loadClass("com.ittest.proxy.$Proxy1");
//        System.out.println(c.getName());
//        System.out.println(c);
        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m =  ctr.newInstance(h);
        return m;
    }
}
