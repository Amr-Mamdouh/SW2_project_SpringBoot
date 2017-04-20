package Model;

public class MultipleQuestion {
	private String Question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private char answer;
	game ga=new game();
	public MultipleQuestion()
	{
		 Question="";
		 answer1="";
		 answer2="";
		 answer3="";
		 answer4="";
	}
	public MultipleQuestion(String question, String answer1, String answer2, String answer3, String answer4) {
		super();
		Question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer;
	}
	public boolean addQuestion(int g_id)
	{
		return ga.add_Multiple_question(Question, answer1,answer2, answer3, answer4, answer, g_id);
	}
}
