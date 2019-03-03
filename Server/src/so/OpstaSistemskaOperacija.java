/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import skladiste.IBrokerBazePodataka;
import skladiste.baza.BrokerBazePodataka;
import skladiste.baza.konekcija.KonekcijaNaBazu;

/**
 *
 * @author Jovana Mitrovic
 */
public abstract class OpstaSistemskaOperacija {
    
    protected IBrokerBazePodataka bbp;

    public OpstaSistemskaOperacija() {
        bbp = new BrokerBazePodataka();
    }

    public final void izvrsenjeSO(Object obj) throws Exception {
        try {
            validiraj(obj);
            try {
                pokreniTransakciju();
                izvrsi(obj);
                commit();
            } catch (Exception ex) {
                rollback();
                throw ex;
            }
        } catch (Exception ex) {
           // ex.printStackTrace();
            throw ex;
        }
    }

    protected abstract void validiraj(Object obj) throws Exception;

    private void pokreniTransakciju() throws Exception {
        KonekcijaNaBazu.getInstanca().pokreniTransakciju();
    }

    protected abstract void izvrsi(Object obj) throws Exception;

    private void commit() throws Exception {
        KonekcijaNaBazu.getInstanca().commit();
    }

    private void rollback() throws Exception {
        KonekcijaNaBazu.getInstanca().rollback();
    }

}
