package qn.projectredstone.api.action;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;
import qn.projectredstone.lang.Action;
import qn.projectredstone.lang.Parameter;

public final class SendMessage implements Action {

	public Parameter getParameter() {
		return new Parameter()
				.addParameter(Text.class, "msg")
				.addParameter(MessageReceiver.class, "to");
	}

	public void run(Parameter parameter) {
		MessageReceiver target = (MessageReceiver) parameter.getValue("to");
		Text message = (Text) parameter.getValue("msg");

		target.sendMessage(message);
	}
}
