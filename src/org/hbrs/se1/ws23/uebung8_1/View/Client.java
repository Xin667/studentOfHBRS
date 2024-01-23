package org.hbrs.se1.ws23.uebung8_1.View;

/**
 * @author dwang2s
 */
public class Client {
    Reiseanbieter adapter;

    public Client(Reiseanbieter adapter) {
        this.adapter = adapter;
    }

    public QueryResult sucheHotel(QueryObject qo) {
        return adapter.executeQuery(qo);
    }
}
