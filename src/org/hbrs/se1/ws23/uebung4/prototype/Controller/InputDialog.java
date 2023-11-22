package org.hbrs.se1.ws23.uebung4.prototype.Controller;

import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.Model.Exception.ContainerException;
import org.hbrs.se1.ws23.uebung4.prototype.Model.UserStory;
import org.hbrs.se1.ws23.uebung4.prototype.View.UserStoryView;

import java.util.List;

/**
 * @author dwang2s
 */
public class InputDialog { //Client
    private Container myContainer = Container.getInstance();
    private List<UserStory> myList = myContainer.getCurrentList();

    public void addMember(UserStory u) throws ContainerException {
        myContainer.addUserStory(u);
    }
    public String deleteUserStory(Integer id){
        return myContainer.deleteUserStory(id);
    }
    public void dump(){
        UserStoryView.dump(myContainer);
    }
}
