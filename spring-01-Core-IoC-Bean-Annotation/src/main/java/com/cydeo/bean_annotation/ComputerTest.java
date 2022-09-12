package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.config.ComputerConfig;
import com.cydeo.bean_annotation.casefactory.config.ObjectConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {


        // Creating container by using Application Context
        ApplicationContext container= new AnnotationConfigApplicationContext(ComputerConfig.class, ObjectConfig.class);

        //Creating container by using BeanFactory
        BeanFactory context=new AnnotationConfigApplicationContext();



     Monitor theMonitor=container.getBean(Monitor.class);
     Case theCase= container.getBean(Case.class);
     Motherboard theMotherboard=container.getBean(Motherboard.class);
     Monitor theMonitor2= container.getBean("Sony", Monitor.class);
     // Using the method name(monitorSony) to refer to the bean you want to add, or by using a custom name added after @Bean
     // @Primary is also a good solution
        PC myPc= new PC(theCase,theMonitor,theMotherboard);
        myPc.powerUp();
    }
}
