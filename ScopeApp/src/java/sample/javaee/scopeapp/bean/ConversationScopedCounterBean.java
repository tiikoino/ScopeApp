package sample.javaee.scopeapp.bean;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "conversationScopedCounterBean")
@ConversationScoped //スコープ宣言
public class ConversationScopedCounterBean implements Serializable {

    public ConversationScopedCounterBean() {    }

    // ConversationScopedを制御するためのクラス
    @Inject
    private Conversation conversation;
    
    private int count;

    @PostConstruct
    public void init() {
        count = 0;
    }

    // スコープの開始メソッド
    //conversationScopedIndex.xhtml先頭でf:eventにて強制的に呼び出す
    public void initConversation() {
        // ポストバックでなくて、且つ、スコープが開始されてなかったら
        if (!FacesContext.getCurrentInstance().isPostback()
                && this.conversation.isTransient()) {
            // スコープの開始
            this.conversation.begin();
        }
    }

    //画面遷移用メソッド
    public String clickNext() {
        return "conversationScopedConfirm?faces-redirect=true";
    }

    //画面遷移用メソッド
    public String clickConfirm() {
        return "conversationScopedCompleted?faces-redirect=true";
    }

    // スコープの終了
    public String clickCompleted() {
        // スコープが開始されてたら終了
        if (!this.conversation.isTransient()) {
            this.conversation.end();
        }
        return "conversationScopedIndex?faces-redirect=true";
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void countUp() {
        count++;
    }
}
