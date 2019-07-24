package com.ljy.Spring0011.xml;

import com.ljy.Spring0011.AbstractBeanDefinitionReader;
import com.ljy.Spring0011.BeanDefinition;
import com.ljy.Spring0011.BeanReference;
import com.ljy.Spring0011.PropertyValue;
import com.ljy.Spring0011.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventListener;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc xml 资源加载
 * */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String localtion) throws Exception {
        InputStream inputStream=getResourceLoader().getResource(localtion).getInputStream();
        doLoadBeanDefinitions(inputStream);

    }

    protected void doLoadBeanDefinitions(InputStream inputStream)throws Exception{
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(inputStream);
        //解析Bean
        registerBeanDefinitions(document);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document document){
        Element root=document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root){
        NodeList nl=root.getChildNodes();
        for(int i=0;i<nl.getLength();i++){
            Node node=nl.item(i);
            if(node instanceof Element){
                Element element=(Element) node;
                processBeanDefinition(element);
            }
        }
    }

    protected void processBeanDefinition(Element element){
        String name=element.getAttribute("name");
        String className=element.getAttribute("class");
        BeanDefinition beanDefinition=new BeanDefinition();
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    protected  void processProperty(Element element,BeanDefinition beanDefinition){
        NodeList nodeList=element.getElementsByTagName("property");
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node instanceof Element){
                Element propertyEle=(Element)node;
                String name=propertyEle.getAttribute("name");
                String value=propertyEle.getAttribute("value");
                if(value!=null&&value.length()>0){
                    beanDefinition.getPropertyValues().getPropertyValues().add(new PropertyValue(name,value));
                }else{
                    String ref=propertyEle.getAttribute("ref");
                    if(ref==null||ref.length()==0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference=new BeanReference(ref);
                    beanDefinition.getPropertyValues().getPropertyValues().add(new PropertyValue(name,beanReference));
                }

            }
        }
    }
}