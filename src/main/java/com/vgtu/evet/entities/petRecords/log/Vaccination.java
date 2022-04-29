/**
 * @(#) Vaccination.java
 */

package com.vgtu.evet.entities.petRecords.log;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vgtu.evet.entities.petRecords.PetRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "vaccinations")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Vaccination
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vaccine_type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private VaccineType vaccineType;

	@Column
	@NotNull
	private Date nextDue;

	@ManyToOne
	@JoinColumn(name = "visit_id", referencedColumnName = "id")
	@NotNull
	private Visit visit;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_record_id", referencedColumnName = "id")
	@NotNull
	@JsonIgnore
	private PetRecord petRecord;
}
