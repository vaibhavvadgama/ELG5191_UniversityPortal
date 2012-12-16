package course.elg5191.university.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import course.elg5191.university.view.CourseInformationData;
import org.primefaces.model.SelectableDataModel;

public class CourseInformationDataModel extends ListDataModel<CourseInformationData> implements SelectableDataModel<CourseInformationData>
{
	//Constructors
	public CourseInformationDataModel() {}
	
	public CourseInformationDataModel(List<CourseInformationData> data)
	{
		super(data);
	}
	//
	
	@Override
	public CourseInformationData getRowData(String rowKey) 
	{
		@SuppressWarnings("unchecked")
		List<CourseInformationData> courses = (List<CourseInformationData>) getWrappedData();
		
		for(CourseInformationData course : courses)
		{
			if(Integer.toString(course.getOfferingId()).equals(rowKey))
				return course;
		}
		return null;
	}

	@Override
	public Object getRowKey(CourseInformationData courseInformation) 
	{
		return Integer.toString(courseInformation.getOfferingId());
	}
	
}
