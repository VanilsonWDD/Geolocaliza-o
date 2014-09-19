/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entityes.Locais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import sessionbeans.LocaisFacade;

/**
 *
 * @author Vanilson
 */
@ManagedBean
@ViewScoped
public class locaisBean implements Serializable {
    @EJB
    private LocaisFacade locaisFacade;
    private Marker marcadores;
    private MapModel modelo;
    /**
     * Creates a new instance of locaisBean
     */
    public locaisBean() {
    }
    @PostConstruct
    public void getModeloMapa() {
        modelo = new DefaultMapModel();
        List<Locais> latitudeLongitude = locaisFacade.findAll();
        for(int i = 0; i < latitudeLongitude.size(); i++){
            modelo.addOverlay(new Marker(new LatLng(latitudeLongitude.get(i).getLatitudeLocal(), latitudeLongitude.get(i).getLongitudeLocal()), 
                                latitudeLongitude.get(i).getNomeLocal()
                                ));            
        }
    }
    
    public MapModel getModelo() {
        return modelo;
    }
    public void onMarkerSelect(OverlaySelectEvent event) {
        marcadores = (Marker) event.getOverlay();
    }
    public Marker getMarker() {
        return marcadores;
    }
}
