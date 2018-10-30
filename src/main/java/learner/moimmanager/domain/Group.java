package learner.moimmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "moim_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User leader;

    @Embedded
    @AssociationOverride(name = "members", joinTable = @JoinTable(name = "moim_group_joined_members"))
    private Members joinedMembers;

    @Embedded
    @AssociationOverride(name = "members", joinTable = @JoinTable(name = "moim_group_join_waiting_members"))
    private Members joinWaitingMembers;

    @Embedded
    private GroupProperties properties;

    public Group() {
    }

    public Group(User opener, GroupProperties properties) {
        leader = opener;
        joinedMembers = new Members(opener);
        // joinWaitingMembers는 무제한으로 대기할 수 있어야 한다
        // 이미 가입 요청한 사람은 가입요청을 보낼 수 없다
        joinWaitingMembers = new Members(opener);
        this.properties = properties;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return properties.getName();
    }

    public int getMemberCount() {
        return joinedMembers.size();
    }

    public int getJoinWaitingMemberCount() {
        return joinWaitingMembers.size();
    }

    public void addMember(User user) {
        joinedMembers.add(user);
    }

    public void joinRequestBy(User member) {
        // TODO 이미 가입대기중일 때 어떻게 알려줄 것인가?
        joinWaitingMembers.add(member);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", leader=" + leader +
                ", joinedMembers=" + joinedMembers +
                ", properties=" + properties +
                '}';
    }
}
