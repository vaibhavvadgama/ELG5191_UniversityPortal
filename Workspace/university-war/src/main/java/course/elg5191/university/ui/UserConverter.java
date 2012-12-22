package course.elg5191.university.ui;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;

@SuppressWarnings("serial")
@ManagedBean(name = "userConverter")
@FacesConverter(value = "userConverter")
public class UserConverter implements Converter, Serializable{

	@EJB
	private UsersSession users;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || value == "null") {
			return null;
		}
		int id = Integer.parseInt(value);
		return (Users) users.getUserById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		}
		if (!(value instanceof Users)) {
            throw new ConverterException("Invalid user: " + value);
        }
		Integer id = ((Users) value).getUserId();
		
		return (id != null) ? id.toString() : null;
	}

}
