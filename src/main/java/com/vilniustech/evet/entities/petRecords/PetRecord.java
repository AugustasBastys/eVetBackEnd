package com.vilniustech.evet.entities.petRecords;

import com.vilniustech.evet.entities.petRecords.log.Surgery;
import com.vilniustech.evet.entities.petRecords.log.Vaccination;
import com.vilniustech.evet.entities.petRecords.log.Visit;
import com.vilniustech.evet.entities.pets.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "pet_records")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "petRecord")
    private List<Vaccination> vaccinations;
}
