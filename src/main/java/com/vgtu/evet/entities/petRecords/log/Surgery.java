/**
 * @(#) Surgery.java
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

@Entity
@Table(name = "surgeries")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Surgery
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String note;

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
