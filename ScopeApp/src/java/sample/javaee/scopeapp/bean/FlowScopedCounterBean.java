
package sample.javaee.scopeapp.bean;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.flow.FlowScoped;

@Named(value = "flowScopedCounterBean")
@FlowScoped("flowScopedCounter")
public class FlowScopedCounterBean {

    public FlowScopedCounterBean() {    }
    
    private int count;

    @PostConstruct
    public void init(){
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void countUp(){
        count++;
    }

}
