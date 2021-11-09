package tech.teamfour.events;

public class TimerStart {
	
    private static TimerStart instance;

    /**
     * This is a singleton class. Hence the private constructor.
     */

    private TimerStart() {}

    /**
     * Returns the only instance of the class.
     *
     * @return the only instance
     */

    public static TimerStart instance() {
	if (instance == null) instance = new TimerStart();
	return instance;
    }

}
