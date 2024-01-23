package org.hbrs.se1.ws23.uebung8_1.Adapter;

import org.hbrs.se1.ws23.uebung8_1.LegacySystem.Hotelsuche;
import org.hbrs.se1.ws23.uebung8_1.LegacySystem.Suchauftrag;
import org.hbrs.se1.ws23.uebung8_1.LegacySystem.Suchergebnis;
import org.hbrs.se1.ws23.uebung8_1.View.QueryObject;
import org.hbrs.se1.ws23.uebung8_1.View.QueryResult;
import org.hbrs.se1.ws23.uebung8_1.View.Reiseanbieter;

/**
 * @author dwang2s
 */
public class ReiseanbieterAdapter implements Reiseanbieter {
    private Hotelsuche hotelsuche;

    public ReiseanbieterAdapter(Hotelsuche hotelsuche) {
        this.hotelsuche = hotelsuche;
    }

    @Override
    public QueryResult executeQuery(QueryObject qo) {
        Suchauftrag oldData = transformEingabe(qo);
        Suchergebnis oldResult = hotelsuche.suche(oldData);
        QueryResult ret = transformAusgabe(oldResult);
        return ret;
    }
    private Suchauftrag transformEingabe(QueryObject qo) {
        return new Suchauftrag();
    }
    private QueryResult transformAusgabe(Suchergebnis s) {
        return new QueryResult();
    }
}
