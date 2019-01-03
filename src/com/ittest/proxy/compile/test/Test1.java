package com.ittest.proxy.compile.test;

import com.ittest.proxy.Movable;
import com.ittest.proxy.Tank;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class Test1 {
    public static void main(String[] args) throws Exception {
        String src =
                "package com.ittest.proxy;\n" +
                        "\n" +
                        "public class TankTimeProxy implements Movable{\n" +
                        "    Movable t;\n" +
                        "\n" +
                        "    public TankTimeProxy(Movable t) {\n" +
                        "        this.t = t;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void move() {\n" +
                        "        long start = System.currentTimeMillis();\n" +
                        "        System.out.println(\"starttime:\"+start);\n" +
                        "        t.move();\n" +
                        "        long end = System.currentTimeMillis();\n" +
                        "        System.out.println(\"time:\"+(end-start));\n" +
                        "    }\n" +
                        "\n" +
                        "}\n";
//        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir")
                + "/src/com/ittest/proxy/TankTimeProxy.java";
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
        URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.ittest.proxy.TankTimeProxy");
//        System.out.println(c);
        Constructor ctr = c.getConstructor(Movable.class);
        Movable m = (Movable) ctr.newInstance(new Tank());
        m.move();
    }
}
