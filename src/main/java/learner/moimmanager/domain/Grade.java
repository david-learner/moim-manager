package learner.moimmanager.domain;

public enum Grade {
    NORMAL(10),
    BUISINESS(100);

    private int groupMemberCapacity;

    private Grade(int groupMemberCapacity) {
        this.groupMemberCapacity = groupMemberCapacity;
    }

    public int getGroupMemberCapacity() {
        return groupMemberCapacity;
    }
}
