package cindy.relation.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cindy.toko.model.UserNonMember;

public interface BarangInterface {

    Long size();
    List<UserNonMember> findAll (int page, int limit);
    UserNonMember findById (@NotNull Long id);
    boolean save(@NotNull UserNonMember unm);
    boolean update(@NotNull Long id, @NotBlank String id_nonmember, @NotBlank String nama); // @NotNull int grade);
    boolean destroy(@NotNull Long id);
}