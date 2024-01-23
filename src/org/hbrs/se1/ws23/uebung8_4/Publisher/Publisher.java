package org.hbrs.se1.ws23.uebung8_4.Publisher;

import org.hbrs.se1.ws23.uebung8_4.Subcriber.Subcriber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwang2s
 */
public abstract class Publisher {
    private List<Subcriber> subscribers;

    public Publisher(List<Subcriber> subscribers) {
        this.subscribers = new ArrayList<>();
    }

    public void register(Subcriber s){
        subscribers.add(s);
    }
    public void deregister(Subcriber s){
        subscribers.remove(s);
    }
    public void notify(Integer id, String topic){
        subscribers.get(id).update(id,topic);
    }
    public abstract void produce();
}
