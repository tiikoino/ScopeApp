package sample.javaee.scopeapp.bean;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "applicationScopedCounterBean")
@ApplicationScoped  //スコープ宣言
public class ApplicationScopedCounterBean {

    public ApplicationScopedCounterBean() {    }
    
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
