package Model;

public class TrueQuestion extends Question{

	private String Question;
	private String Answer;
	game ga=new game();
	public TrueQuestion()
	{
		Question="";
		Answer="";
	}
	public TrueQuestion(String question, String answer) {
		super();
		Question = question;
		Answer = answer;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public boolean addgame(int g_id)
	{
		return ga.addtrue_question(Question, Answer, g_id);
	}
	
	
	
}
