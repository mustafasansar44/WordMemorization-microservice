package com.msansar.wordgroupservice.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wordGroups")
public class WordGroup{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true)
    private String id;

    @CreatedDate
    @Column(updatable = false)
    private Date createdAt = new Date();

    @LastModifiedDate
    private Date updatedAt = new Date();
    private String foreignWord;
    private String localWord;
    private boolean isActive = true;
    @Max(10) @Min(1)
    private int difficultLevel = 1;


    public WordGroup(String foreignWord, String localWord, int difficultLevel) {
        this.foreignWord = foreignWord;
        this.localWord = localWord;
        this.difficultLevel = difficultLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordGroup wordGroup = (WordGroup) o;
        return isActive == wordGroup.isActive && Objects.equals(foreignWord, wordGroup.foreignWord) && Objects.equals(localWord, wordGroup.localWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foreignWord, localWord, isActive);
    }
}
