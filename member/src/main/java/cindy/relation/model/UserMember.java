package cindy.relation.model;

import java.util.*;
import javax.persistence.*;
/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
*/


import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usermember")
public class UserMember{

    @OneToMany(
        mappedBy = "usermember",
        cascade = CascadeType.ALL
    )
    private List<MemberNonMemberActivity> mnma = new ArrayList<>();

    public List<MemberNonMemberActivity> getMemberNonMemberActivity(){
        return mnma;
    }

    public void setMemberNonMemberActivity(List<MemberNonMemberActivity> mnma){
        this.mnma = mnma; 
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull (message = "nama harus diisi.")
    @Column(name = "id_member")
    private String id_member;

    @NotNull (message = "nama harus diisi.")
    @Column(name = "nama")
    private String nama;

    @NotNull (message = "id harus diisi.")
    @Column(name = "password")
    private String password;

    @NotNull (message = "id harus diisi.")
    @Column(name = "email")
    private String email;


   

    
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

    public String getIdMember(){
        return id_member;
    }

    public void setIdMember(String id_member){
        this.id_member=id_member;
    }
    

    public String getNama() {
        return nama;
    }
    

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }
    

    public void setEmail(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    

    public void setEmail(String email) {
        this.email = email;
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