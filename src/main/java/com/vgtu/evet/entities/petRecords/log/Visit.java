/**
 * @(#) Visit.java
 */

package com.vgtu.evet.entities.petRecords.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.petRecords.PetRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "visits")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Visit
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointment;

	@Column
	private double weight;

	@Column
	private double temp;

	@Column(name = "blood_pressure")
	private String bloodPressure;

	@Column
	private int pulse;

	@Column
	private String diagnosis;

	@Column
	@NotNull
	private Date date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_record_id", referencedColumnName = "id")
	@NotNull
	@JsonIgnore
	private PetRecord petRecord;
}
