/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entityes.Locais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vanilson
 */
@Stateless
public class LocaisFacade extends AbstractFacade<Locais> {
    @PersistenceContext(unitName = "Geolocalizacao-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocaisFacade() {
        super(Locais.class);
    }
    
}
