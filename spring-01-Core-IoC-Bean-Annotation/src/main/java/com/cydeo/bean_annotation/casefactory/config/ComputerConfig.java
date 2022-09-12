package com.cydeo.bean_annotation.casefactory.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean(name="Sony")
    public Monitor monitorSony(){
        return new SonyMonitor("25 inch  Beast", "Acer", 25);
    }
    @Bean @Primary
    public Monitor monitorAcer(){
        return new AcerMonitor("25 inch  Beast", "Acer", 25);
    }
    @Bean
    public Case dellCase(){
        return new DellCase("happy", "sony", "awesome");
    }

    @Bean
    public Motherboard AsusMotherBoard(){
        return new AsusMotherboard("hi", "Sony", 3, 4,"Nice");
    }

}
