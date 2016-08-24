package cn.southstone.wuye.server.domain;

import javax.persistence.*;

/**
 * Created by fengs on 2016/8/22.
 */
@Entity
@DiscriminatorValue("gr")
public class GrCustomer extends Customer{


    private static final long serialVersionUID = -1321941811019187491L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gr_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
