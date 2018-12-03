package learner.moimmanager.domain;

public enum Grade {
    NORMAL(10, 5, 10),
    BUISINESS(100, 10, 100);

    private int openCapacity;
    private int joinCapacity;
    private int memberCapacity;

    private Grade(int openCapacity, int joinCapacity, int memberCapacity) {
        this.openCapacity = openCapacity;
        this.joinCapacity = joinCapacity;
        this.memberCapacity = memberCapacity;
    }

    public int getOpenCapacity() {
        return openCapacity;
    }

    public int getJoinCapacity() {
        return joinCapacity;
    }

    public int getMemberCapacity() {
        return memberCapacity;
    }
}
