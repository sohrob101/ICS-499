package tech.teamfour.timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Clock implements Runnable {
    private Thread thread = new Thread(this);
    private static Clock clock;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
	this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
	this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private Clock() {
	thread.start();
    }

    public static Clock instance() {
	if (clock == null) clock = new Clock();
	return clock;
    }

    public void run() {

        try {
            long oneTenthSecondAdjusted = 100L;
            while (true) {
                long timeBeforeSleep = System.currentTimeMillis();
                Thread.sleep(oneTenthSecondAdjusted);
                this.propertyChangeSupport.firePropertyChange(null, null, null);
                long timeAfterSleep = System.currentTimeMillis();
                long actualElapsedTime = timeAfterSleep - timeBeforeSleep;

                //correct drift that comes from Thread's sleep method
                if(actualElapsedTime > 100L){
                    oneTenthSecondAdjusted = 100L - (actualElapsedTime - 100L);
                }else {
                    oneTenthSecondAdjusted = 100L;
                }
            }
        } catch (InterruptedException ie) {}
    }
}
