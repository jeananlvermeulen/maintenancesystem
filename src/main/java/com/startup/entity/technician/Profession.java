package com.startup.entity.technician;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */

@Entity
public class Profession implements Serializable {

    @Id
    private String professionId;
    private String profName;
    private String profDesc;

    protected Profession() {
    }

    private Profession(Builder builder) {

        this.professionId = builder.professionId;
        this.profName = builder.profName;
        this.profDesc = builder.profDesc;
    }

    public String getProfessionId() {
        return professionId;
    }

    public String getProfName() {
        return profName;
    }

    public String getProfDesc() {
        return profDesc;
    }

    public static class Builder{

        private String professionId;
        private String profName;
        private String profDesc;


        public Builder professionId(String professionId) {
            this.professionId = professionId;
            return this;
        }


        public Builder profName(String profName) {
            this.profName = profName;
            return this;
        }


        public Builder profDesc(String profDesc) {
            this.profDesc = profDesc;
            return this;
        }


        public Builder copy(Profession profession){
            this.professionId = profession.professionId;
            this.profName = profession.profName;
            this.profDesc = profession.profDesc;

            return this;
        }

        public Profession build() {
            return new Profession(this);
        }

    }

    @Override
    public String toString() {
        return "Profession{" +
                "professionId='" + professionId + '\'' +
                ", profName='" + profName + '\'' +
                ", profDesc='" + profDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession profession = (Profession) o;
        return professionId.equals(profession.professionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professionId);
    }
}
