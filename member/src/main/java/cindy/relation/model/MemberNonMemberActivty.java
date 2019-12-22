package cindy.relation.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "membernonmemberact")
public class MemberNonMemberActivity{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member")
    private UserMember usermember;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "id_nonmember")
    private UserNonMember usernonmember;


public UserNonMember getUserNonMember(){
    return usermember;
}

public void setUserNonMember(UserNonMember usernonmember){
    this.usernonmember=usernonmember;
}

    public UserMember getUserMember(){
        return usermember;
    }

    public void setUserMember(UserMember usermember){
        this.usermember = usermember;
    }


   
    @NotNull (message = "password harus diisi.")
    @Column(name = "post_member")
    private String post_member;

    @NotNull (message = "password harus diisi.")
    @Column(name = "post_non_member")
    private String post_non_member;

    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "deleted_at")
    private Date deleted_at;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostNonMember() {
        return post_non_member;
    }

    public void setPostNonMember(String post_non_member) {
        this.post_non_member = post_non_member;
    }

    public String getPostMember(){
        return post_member;
    }

    public void setPostMember(String post_member){
        this.post_member=post_member;
    }

    

   
    public Date getCreated_At() {
        return created_at;
    }

    public void setCreated_At(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_At() {
        return updated_at;
    }

    public void setUpdated_At(Date updated_at) {

        this.updated_at = updated_at;
    }

    public Date getDeleted_At() {
        return deleted_at;
    }
    
    public void setDeleted_At(Date deleted_at) {

        this.deleted_at = deleted_at;
    }

}