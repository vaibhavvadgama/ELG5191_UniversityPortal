package course.elg5191.university.ui;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import course.elg5191.university.beans.entity.Courses;
import course.elg5191.university.beans.session.CoursesSession;

@SuppressWarnings("serial")
@ManagedBean(name = "courseConverter")
@FacesConverter(value = "courseConverter")
public class CourseConverter implements Converter, Serializable {

	@EJB
	private CoursesSession courses;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.isEmpty() || value == "null") {
			return null;
		}
		int id = Integer.parseInt(value);
		return (Courses) courses.getByCourseId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return null;
		}
		if (!(value instanceof Courses)) {
			throw new ConverterException("Invalid course: " + value);
		}
		Integer id = ((Courses) value).getCourseId();
		return (id != null) ? id.toString() : null;
	}
}
