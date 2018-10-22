package learner.moimmanager.domain;

public class GroupProperties {
    User leader;
    String name;
    String category;
    String connectType;
    String region;

    public GroupProperties(User leader, String name, String category, String connectType, String region) {
        this.leader = leader;
        this.name = name;
        this.category = category;
        this.connectType = connectType;
        this.region = region;
    }

    public User getLeader() {
        return leader;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getConnectType() {
        return connectType;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "GroupProperties{" +
                "leader=" + leader +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", connectType='" + connectType + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
