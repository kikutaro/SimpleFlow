package sample.simpleflow;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.flow.FlowScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kikuta
 */
@Named(value = "flowBean")
@FlowScoped("first")
public class FlowBean implements Serializable{
    @Getter @Setter
    private String name;
    
    public void init(){
        System.out.println("init");
    }
}
