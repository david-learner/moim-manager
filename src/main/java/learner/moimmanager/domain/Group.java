package learner.moimmanager.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moim_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Member leader;

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

    public Group(Member opener, GroupProperties properties) {
        leader = opener;
        joinedMembers = new Members(opener);
        // TODO joinWaitingMembers는 적정인원으로 대기할 수 있어야 한다
        // TODO 이미 가입 요청한 사람은 가입요청을 보낼 수 없다
        joinWaitingMembers = new Members(opener);
        this.properties = properties;
    }

    public long getId() {
        return id;
    }

    public Member getLeader() {
        return leader;
    }

    public String getName() {
        return properties.getName();
    }

    public int getMemberCount() {
        return joinedMembers.size();
    }

    public List<String> getJoinedMembersName() {
        return joinedMembers.getMembersName();
    }

    public Members getJoinWaitingMembers() {
        return joinWaitingMembers;
    }

    public int getJoinWaitingMemberCount() {
        return joinWaitingMembers.size();
    }

    public void addMember(Member member) {
        joinedMembers.add(member);
    }

    public void joinRequestBy(Member member) {
        joinWaitingMembers.add(member);
    }

    public boolean matchLeader(Member member) {
        return leader.equals(member);
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

    public void accept(Member joinWaitingMember) {
        // TODO 만약 !ifPresent일 때 NPE를 어떻게 발생시킬 것인가?
        joinWaitingMembers.getMembers().stream().filter(user -> user.equals(joinWaitingMember)).findAny().ifPresent(user -> {
            joinedMembers.add(user);
            joinWaitingMembers.remove(user);
        });
    }
}
