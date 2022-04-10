package com.vgtu.evet.entities.petRecords;

import com.vgtu.evet.entities.petRecords.log.Surgery;
import com.vgtu.evet.entities.petRecords.log.Visit;
import com.vgtu.evet.entities.pets.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "pet_record")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PetRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @NotNull
    private Pet pet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "petRecord")
    private List<Condition> conditions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "petRecord")
    private List<Visit> visits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "petRecord")
    private List<Surgery> surgeries;
}
