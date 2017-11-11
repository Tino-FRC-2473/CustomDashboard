package application;

public class ConsoleUpdater {
	private Console console;

	public ConsoleUpdater(Console console) {
		this.console = console;
	}

	public void updateConsole(String text) {
		console.addText(text);
	}
}
