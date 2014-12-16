package sample.javaee.scopeapp.bean;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "dependentCounterBean")
@Dependent
public class DependentCounterBean {

    public DependentCounterBean() {    }

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
