package sample.javaee.scopeapp.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@Named(value = "sessionScopedCounterBean")
@SessionScoped
public class SessionScopedCounterBean implements Serializable {

    public SessionScopedCounterBean() {    }
    
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
