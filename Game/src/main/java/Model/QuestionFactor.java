package Model;

public class QuestionFactor {
	Question getQuestion(String s)
	{
		if(s.equals("True&False"))
			return  new TrueQuestion();
		else 
			return new MultipleQuestion();
	}

}
