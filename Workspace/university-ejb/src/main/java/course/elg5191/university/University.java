package course.elg5191.university;

public class University 
{
	public enum PrereqType
	{
		Course,
		Experience,
		Technology
	}
	
	public enum ExamType
	{
		Assignment,
		Project,
		Midterm,
		Final,
		Quiz
	}
	
	public enum ConductType
	{
		Inclass,
		Takehome
	}
	
	public enum ExamSubmissionStatus
	{
		Pass,
		Fail
	}
	
	public enum StudentApplicationStatus
	{
		DecisionPending,
		Accepted,
		Rejected,
		OnHold
	}
	
	public enum StudentCourseRegistrationStatus
	{
		Current,
		Pass,
		Fail,
		Dropped
	}
	
	public enum UserRole
	{
		Admin,
		Professor,
		Student
	}
	
	public enum Term
	{
		Fall,
		Winter,
		Summer
	}
}
