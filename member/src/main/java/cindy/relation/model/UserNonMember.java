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
@Table(name = "usernonmember")
public class UserNonMember{

    @OneToMany(
        mappedBy = "usernonmember",
        cascade = CascadeType.ALL
    )
    private List<MemberNonMemberActivity> mnma = new ArrayList<>();

    public List<MemberNonMemberActivity> getMemberNonMeberActivity(){
        return mnma;
    }

    public void setTransaksi(List<MemberNonMemberActivity> mnma){
        this.mnma = mnma; 
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull (message = "nama harus diisi.")
    @Column(name = "id_nonmember")
    private String id_nonmember;

    @NotNull (message = "nama harus diisi.")
    @Column(name = "nama")
    private String nama;

    
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
    

    public String getIdNonMember() {
        return id_nonmember;
    }
    

    public void setIdNonMember(String id_nonmember) {
        this.id_nonmember = id_nonmember;
    }

    public String getNama() {
        return nama;
    }
    

    public void setNama(String nama) {
        this.nama = nama;
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