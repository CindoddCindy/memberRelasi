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
import cindy.toko.model.UserMember;

@Singleton
public class MemberRepository implements MemberInterface {

    @PersistenceContext
    private EntityManager manager;

    public MemberRepository(@CurrentSession EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from UserMember where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional
    public List<UserMember> findAll(int page, int limit) {
        TypedQuery<UserMember> query = manager
                .createQuery("from UserMember where deleted_at IS NULL", UserMember.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserMember findById(@NotNull Long id) {
        UserMember query = manager.find(UserMember.class, id);
        return query;
    }

    @Override
    @Transactional
    public boolean save(@NotNull UserMember userMember) {
        try {
            manager.persist(userMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(@NotNull Long id, String id_member, String nama, String password, String email) {
        try {

            UserMember usermember = manager.find(UserMember.class, id);
            if (id_member.equals("-")==false) usermember.setIdMember(id_member);
            if (nama.equals("-")==false) userMember.setNama(nama);
            if (password.equals("-")==false) usermember.setPassword();
            if (email.equals("-")==false) usermember.setEmail(email);
          
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
            UserMember usermember = manager.find(UserMember.class, id);
            usermember.setDeleted_At(new Date());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}