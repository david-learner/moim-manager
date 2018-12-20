package learner.moimmanager.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "moim_group")
public class Group {

    private static final Logger log =  LoggerFactory.getLogger(Group.class);

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
        // 가입신청중인지 확인하는 로직

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

    public void reject(Member member) {
        log.debug("Reject remove before : " + joinWaitingMembers.toString());
        joinWaitingMembers.remove(member);
        log.debug("Reject remove after : " + joinWaitingMembers.toString());
    }
}
