package com.vgtu.evet.entities.pets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "owned_pets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnedPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;


}
