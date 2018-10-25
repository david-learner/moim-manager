package learner.moimmanager.domain;

public enum Grade {
    NORMAL(10),
    BUISINESS(100);

    private int capacity;

    private Grade(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
