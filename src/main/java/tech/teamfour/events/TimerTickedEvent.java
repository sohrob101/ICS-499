package tech.teamfour.events;

public class TimerTickedEvent {
    private int time;

    /**
     * This is a singleton class. Hence the private constructor.
     */

    public TimerTickedEvent(int value) {
	this.time = value;
    }

    /**
     * Returns the only instance of the class.
     *
     * @return the only instance
     */

    public int getTimeValue() {
	return time;
    }
}
