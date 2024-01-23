package org.hbrs.se1.ws23.uebung4.prototype.mysolution.Controller;

import org.hbrs.se1.ws23.uebung4.prototype.improvements.model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.Exception.ContainerException;
import org.hbrs.se1.ws23.uebung4.prototype.mysolution.Model.UserStory;
import org.hbrs.se1.ws23.uebung4.prototype.mysolution.View.UserStoryView;

import java.util.List;

/**
 * @author dwang2s
 */
public class InputDialog { //Client
    private Container myContainer = Container.getInstance();
    private List<org.hbrs.se1.ws23.uebung4.prototype.improvements.model.UserStory> myList = myContainer.getCurrentList();

/*    public void addMember(UserStory u) throws ContainerException {
        myContainer.addUserStory(u);
    }*/
    public String deleteUserStory(Integer id){
        return myContainer.deleteUserStory(id);
    }
/*    public void dump(){
        UserStoryView.dump(myContainer);
    }*/
}
