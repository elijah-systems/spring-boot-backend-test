package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Books {
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "author")
    private String author;

    @JsonProperty(value = "ISBN")
    private String ISBN;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "publisher")
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonProperty("users")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users users;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
