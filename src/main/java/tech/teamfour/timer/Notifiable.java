package tech.teamfour.timer;


import tech.teamfour.events.TimerStart;
import tech.teamfour.events.TimerStop;
import tech.teamfour.events.TimerTickedEvent;

/**
 * An entity that can be notified of timing events
 *
 */
public interface Notifiable {
	
    public void handleEvent(TimerTickedEvent event);
    public void handleEvent(TimerStart event);
    public void handleEvent(TimerStop event);

}