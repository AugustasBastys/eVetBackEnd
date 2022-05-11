/**
 * @(#) Appointment.java
 */

package com.vilniustech.evet.entities.appointments;

import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.entities.vetServices.AvailableTime;
import com.vilniustech.evet.entities.vetServices.VetService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "appointments")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Appointment
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	@NotNull
	private VetService vetService;

	@ManyToOne
	@JoinColumn(name = "pet_id", referencedColumnName = "id")
	@NotNull
	private Pet pet;

	@ManyToOne
	@JoinColumn(name = "available_time_id", referencedColumnName = "id")
	@NotNull
	private AvailableTime availableTime;

	@Column(name = "owners_comment")
	private String ownersComment;

	@Column
	private boolean canceled;
}
