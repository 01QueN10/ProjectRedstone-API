package qn.projectredstone.lang;

import java.util.HashMap;
import java.util.Map;

public final class Parameter {

	private Map<String, Class> types = new HashMap<>();
	private Map<String, Class> typesOptional = new HashMap<>();
	private Map<String, Object> values = new HashMap<>();

	public Parameter addParameter(Class type, String index) {
		types.put(index, type);
		return this;
	}

	public Parameter addOptional(Class type/*, Class<? extends EventParameter> defaultValue*/, String index) {
		typesOptional.put(index, type);
		return this;
	}

	public void setValue(String index, Object value) {
		if (!types.get(index).isInstance(value)) {
			//ERROR HANDLING
			return;
		}
		values.put(index, value);
	}

	public Class getType(String index) {
		return types.get(index);
	}

	public Object getValue(String index) {
		return values.get(index);
	}

	//TODO Provide the event
}
