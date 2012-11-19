package course.elg5191.university.ui;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.session.CourseOfferingSession;
import course.elg5191.university.beans.entity.CourseOffering;

/**
 * @author jmccausl
 * @version 1.0
 * @created 17-Nov-2012 7:13:43 AM
 */

@ManagedBean(name = "courseOfferingBean")
@SessionScoped
public class CourseOfferingsBean 
{
	//Declarations
	@EJB
	private CourseOfferingSession courseOfferingSess;
	private List<CourseOffering> courseOfferings;
	
	//Constructors
	public CourseOfferingsBean()
	{

	}
	
	//Public Methods

}