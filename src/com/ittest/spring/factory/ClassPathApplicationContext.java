package com.ittest.spring.factory;

import com.ittest.abstract_factory.factory.MagicStick;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClassPathApplicationContext implements BeanFactory {
    private Map<String, Object> map = new HashMap<>();
    public ClassPathApplicationContext(String fileName) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(fileName);
        Element root = document.getRootElement();
//        System.out.println(root);
        List<Element> elements = root.elements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String clazz = element.attributeValue("class");
            Object o = null;
            try {
                o = Class.forName(clazz).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            map.put(id, o);
        }
    }

    @Override
    public Object getBean(String id) {
        Object o = map.get(id);
        return o;
    }
}
