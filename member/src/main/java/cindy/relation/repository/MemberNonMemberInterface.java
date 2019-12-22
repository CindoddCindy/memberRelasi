package cindy.relation.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cindy.toko.model.MemberNonMemberActivity;

public interface MemberNonMemberInterface {

    Long size();
    List<MemberNonMemberActivity> findAll (int page, int limit);
    MemberNonMemberActivity findById (@NotNull Long id);
    boolean save(@NotNull MemberNonMemberActivity mnma);
    boolean update(@NotNull Long id, @NotBlank String id_member, @NotBlank String id_nonmember, @NotBlank String post_nonmember, @NotBlank String member); // @NotNull int grade);
    boolean destroy(@NotNull Long id);
}