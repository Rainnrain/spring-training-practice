package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {
@Autowired // feild injection, not preferred
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

@Autowired // Can do constructor injection only required if more than one constructor
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
       this.monitor = monitor;
       this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
