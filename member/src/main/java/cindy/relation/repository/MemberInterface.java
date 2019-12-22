package cindy.relation.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cindy.relation.model.UserMember;

public interface MemberInterface {

    Long size();
    List<UserMember> findAll (int page, int limit);
    UserMember findById (@NotNull Long id);
    boolean save(@NotNull UserMember um);
    boolean update(@NotNull Long id, @NotBlank String id_member, @NotBlank String nama,  @NotBlank String password,  @NotBlank String email); // @NotNull int grade);
    boolean destroy(@NotNull Long id);
}