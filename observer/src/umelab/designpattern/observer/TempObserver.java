package umelab.designpattern.observer;

public class TempObserver implements IObserver {

    @Override
    public void update(AbstractSubject subject) {
        int temp = subject.getStatus();
        System.out.println("temperature: " + temp);
    }
    
}
