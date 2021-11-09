package tech.teamfour.events;

public class TimerStop {
	
    private static TimerStop instance;

    /**
     * This is a singleton class. Hence the private constructor.
     */

    private TimerStop() {}

    /**
     * Returns the only instance of the class.
     *
     * @return the only instance
     */

    public static TimerStop instance() {
	if (instance == null) instance = new TimerStop();
	return instance;
    }

}
