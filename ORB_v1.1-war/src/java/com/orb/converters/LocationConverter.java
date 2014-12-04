/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.converters;

import com.orb.ejb.ORB_LocationFacadeLocal;
import com.orb.entities.ORB_Location;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author -Bernardo
 */
/*
@ManagedBean
@RequestScoped
public class LocationConverter implements Converter {
    
    @EJB
    private ORB_LocationFacadeLocal locationFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return locationFacade.find(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Location ID", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof ORB_Location) {
            return String.valueOf(((ORB_Location) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Location", modelValue)));
        }
    }
}
*/