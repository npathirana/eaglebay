package com.eagle.portal.web.domain;

import com.eagle.user.domain.User;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Buyer Entity class
 * @see com.eagle.user.domain.User
 * @author Harshana Samaranayake
 */
@Entity
@Table(name = "buyer", schema = "eagle")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id",column = @Column(name = "user_id"))
public class Buyer extends User {
    private byte receiveNewsLetter;
    @OneToOne
    @JoinColumn(name = "contact_id",referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private ContactInfo contactId;

    @Basic
    @Column(name = "receive_news_letter")
    public byte getReceiveNewsLetter() {
        return receiveNewsLetter;
    }

    public void setReceiveNewsLetter(byte receiveNewsLetter) {
        this.receiveNewsLetter = receiveNewsLetter;
    }


    public ContactInfo getContactId() {
        return contactId;
    }

    public void setContactId(ContactInfo contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer that = (Buyer) o;

        if (receiveNewsLetter != that.receiveNewsLetter) return false;
        if (contactId != null ? !contactId.equals(that.contactId) : that.contactId != null) return false;

        return true;
    }
}
