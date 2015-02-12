package sample.simpleflow;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;

/**
 *
 * @author kikuta
 */
@Named
@Dependent
public class FlowDef {
    public final String firstFlowId = "first";
    public final String secondFlowId = "second";
    
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder){
        flowBuilder.initializer("#{flowBean.init()}");
        flowBuilder.id("", firstFlowId);
        flowBuilder.viewNode(firstFlowId, "/firstFlow.xhtml").markAsStartNode();
        flowBuilder.viewNode(secondFlowId, "/secondFlow.xhtml");
        //not work redirect
        flowBuilder.navigationCase().fromOutcome(firstFlowId).toViewId("/secondFlow.xhtml").redirect();
        return flowBuilder.getFlow();
    }
}
