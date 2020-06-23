package com.startup.entity;

import java.util.Objects;

public class Profession {

    private String professionId;
    private String name;
    private String description;

    public Profession() {
    }

    private Profession(Profession.Builder builder) {
        this.professionId = builder.professionId;
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getProfessionId() {
        return professionId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{

        private String professionId;
        private String name;
        private String description;

        public Profession.Builder professionId(String professionId) {
            this.professionId = professionId;
            return this;
        }

        public Profession.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Profession.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Profession.Builder copy(Profession profession){
            this.professionId = profession.professionId;
            this.name = profession.name;
            this.description = profession.description;

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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
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
