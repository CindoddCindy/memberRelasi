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
import cindy.toko.model.UserNonMember;

@Singleton
public class NonMemberRepository implements NonMemberInterface {

    @PersistenceContext
    private EntityManager manager;

    public NonMemberRepository(@CurrentSession EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from UserNonMember where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional
    public List<UserNonMember> findAll(int page, int limit) {
        TypedQuery<UserNonMember> query = manager
                .createQuery("from UserNonMember where deleted_at IS NULL", UserNonMember.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserNonMember findById(@NotNull Long id) {
        UserNonMember query = manager.find(UserNonMember.class, id);
        return query;
    }

    @Override
    @Transactional
    public boolean save(@NotNull UserNonMember usernonmember) {
        try {
            manager.persist(usernonmember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(@NotNull Long id, String id_barang, String nama) {
        try {

            UserNonMember unm = manager.find(Barang.class, id);
            if (id_nonmember.equals("-")==false) unm.setIdNonMember(id_nonmember);
            if (nama.equals("-")==false) unm.setNama(nama);
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
            UserNonMember unm = manager.find(UserNonMember.class, id);
            unm.setDeleted_At(new Date());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}