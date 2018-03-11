package qn.projectredstone.loader;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import qn.projectredstone.lang.Action;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Plugin(id = "projectredstone", name = "ProjectRedstone-API", version = "1.0 BETA")
public final class ScriptLoader {

	private static ScriptLoader instance;

	@Inject
	private Logger logger;
	private static File scriptPath = new File("scripts");

	private ArrayList<Properties> properties = new ArrayList<>();
	private ArrayList<File> scripts = new ArrayList<>();
	private ArrayList<Action> actions = new ArrayList<>();

	@Listener
	public void singeton(GameConstructionEvent event) {
		instance = this;
	}

	@Listener
	public void constructScript(GamePreInitializationEvent event) {
		File[] scripts = scriptPath.listFiles((file, filename) -> filename.toLowerCase().endsWith(".script"));
		if (scripts == null) logger.warn("No scripts were found.");
		else {
				for (File script : scripts) {
					try (FileInputStream input = new FileInputStream(script)) {
						loadScript(IOUtils.toString(input, "UTF-8"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("Could not read the script: " + script.getName());
						e.printStackTrace();
					}
				}
		}
	}

	private void loadScript(String s) {

	}
/*
	private void unzipScripts() {
		File[] files_ = scriptPath.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".zip"));
		if (files_ == null) return;
		List<File> files = Arrays.asList(files_);

		try {
			for (File file : files) {
				ZipFile zip = new ZipFile(file);
				z
			}
		} catch (ZipException e) {
			e.printStackTrace();
		}


		try {
			ArrayList<URL> fileURL = new ArrayList<>();
			for (File jar : scripts) fileURL.add(jar.toURI().toURL());
			URL[] fileURL_ = new URL[fileURL.size()];
			fileURL.toArray(fileURL_);
			URLClassLoader classLoader = new URLClassLoader(fileURL_);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	} */

	public Logger getLogger() {
		return logger;
	}

	public static ScriptLoader getInstance() {
		return instance;
	}

	static class Properties {

		public String id;
		public String name;
		public int version;
		public String display_version;
		public String author;
		public Statement[] statements;
		//public String[] events;

		private static String idPattern = "\\w+";
		private static String namePattern = "[a-zA-z]";
		private static String packagePattern = "[\\w\\.]";

		/*public boolean check() {
			if (!Pattern.matches(idPattern, id)) return false;
			for (Statement statement : statements) {
				if (!Pattern.matches(namePattern, statement.name)) return false;
				for (Map.Entry entry : statement.arguments.entrySet()) {
					entry.getKey()
				}
			}
		} */
	}

	static class Statement {

		public String name;
		public String description;
		public HashMap<String, String> arguments;
	}

}
