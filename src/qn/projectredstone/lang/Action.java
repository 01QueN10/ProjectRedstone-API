package qn.projectredstone.lang;

public interface Action {

	Parameter getParameter();

	void run(Parameter parameter);
}
