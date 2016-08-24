package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fengs on 2016/8/19.
 */
@MappedSuperclass
public class AbstractEntity implements CustomEntity {


    private static final long serialVersionUID = -6248932950096016460L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(columnDefinition = "serial", insertable = false)
    protected Long index;


    @Column(name = "version")
    @Version
    protected Integer version;

    @Column(name = "createdTime")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdTime;

    @Column(name = "lastModifiedTime")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedTime;

    @Column(name = "unlocked")
    protected Boolean unlocked;

    @Column(name = "unexpired")
    protected Boolean unexpired;

    @Column(name = "available")
    protected Boolean available;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIndex() {
        return index;
    }


    public Boolean isNew() {
        return null == getId();
    }

    public void setIndex(Long index) {
        this.index = index;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(Boolean unlocked) {
        this.unlocked = unlocked;
    }

    public Boolean isUnexpired() {
        return unexpired;
    }

    public void setUnexpired(Boolean unexpired) {
        this.unexpired = unexpired;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedTime(new Date());
        this.setLastModifiedTime(new Date());
    }

    @PreUpdate
    protected void onPersist() {
        this.setLastModifiedTime(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }
}
