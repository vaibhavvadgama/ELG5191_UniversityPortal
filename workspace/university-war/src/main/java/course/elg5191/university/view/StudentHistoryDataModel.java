package course.elg5191.university.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import course.elg5191.university.view.StudentHistoryData;
import org.primefaces.model.SelectableDataModel;

//Tim

public class StudentHistoryDataModel extends ListDataModel<StudentHistoryData> implements SelectableDataModel<StudentHistoryData>
{
	//Constructors
	public StudentHistoryDataModel() {}
	
	public StudentHistoryDataModel(List<StudentHistoryData> data)
	{
		super(data);
	}
	//
	
	@Override
	public StudentHistoryData getRowData(String rowKey) 
	{
		@SuppressWarnings("unchecked")
		List<StudentHistoryData> shs = (List<StudentHistoryData>) getWrappedData();
		
		for(StudentHistoryData sh : shs)
		{
			if(Integer.toString(sh.getOfferingId()).equals(rowKey))
				return sh;
		}
		return null;
	}

	@Override
	public Object getRowKey(StudentHistoryData sh) 
	{
		return Integer.toString(sh.getOfferingId());
	}
	
}
