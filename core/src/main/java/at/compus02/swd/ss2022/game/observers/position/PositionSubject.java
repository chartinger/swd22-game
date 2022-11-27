package at.compus02.swd.ss2022.game.observers.position;

public interface PositionSubject {
    public void registerObserver(PositionObserver observer);

    public void unregisterObserver(PositionObserver observer);

    public void notifyObservers();
}
