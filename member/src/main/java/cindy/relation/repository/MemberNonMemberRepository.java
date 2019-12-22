package cindy.relation.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import cindy.relation.model.MemberNonMemberActivity;

@Singleton
public class MemberNonMemberRepository implements MemberNonMemberInterface {

    @PersistenceContext
    private EntityManager manager;

    public MemberNonMemberRepository(@CurrentSession EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from membernonmemberact where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional
    public List<MemberNonMemberActivity> findAll(int page, int limit) {
        TypedQuery<MemberNonMemberActivity> query = manager
                .createQuery("from membernonmemberact where deleted_at IS NULL",MemberNonMemberActivity.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public MemberNonMemberActivity findById(@NotNull Long id) {
        Barang query = manager.find(MemberNonMemberActivity.class, id);
        return query;
    }

    @Override
    @Transactional
    public boolean save(@NotNull MemberNonMemberActivity mnma) {
        try {
            manager.persist(mnma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(@NotNull Long id, String id_member, String id_nonmember, String member_post, String non memberpost) {
        try {

            MemberNonMemberActivity mnma = manager.find(MemberNonMemberActivity.class, id);
            if (id_member.equals("-")==false) mnma.setIdMember(id_member);
            if (id_nonmember.equals("-")==false) mnma.setIdNonMember(id_nonmember);
            if (member_post.equals("-")==false) mnma.setMemberPost(member_post);
            if (nonmember_post.equals("-")==false) mnma.setIdNonMemberPost(non_memberpost);
           
           // if (jam_pulang.equals("-")==false) c.setJamPulang(jam_pulang);
          
          //  if (grade != 0) c.setGrade(grade);
            c.setUpdated_At(new Date());
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean destroy(@NotNull Long id) {
        try {
            MemberNonMemberActivity mnma = manager.find(MemberNonMemberActivity.class, id);
            mnma.setDeleted_At(new Date());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}