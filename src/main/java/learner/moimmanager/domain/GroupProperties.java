package learner.moimmanager.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupProperties {

    @Column(length = 10, nullable = false, unique = true)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

    @Column(length = 9, nullable = false)
    private String connect_type;

    @Column(length = 5, nullable = false, unique = true)
    private String region;

    public GroupProperties() {
    }

    public GroupProperties(String name, String category, String connect_type, String region) {
        this.name = name;
        this.category = category;
        this.connect_type = connect_type;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getConnect_type() {
        return connect_type;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "GroupProperties{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", connect_type='" + connect_type + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
