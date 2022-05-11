/**
 * @(#) Conditions.java
 */

package com.vilniustech.evet.entities.petRecords;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conditions")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Condition
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "condition_name")
	@NotNull
	private String conditionName;

	@Column
	private String note;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_record_id", referencedColumnName = "id")
	@NotNull
	@JsonIgnore
	private PetRecord petRecord;
}
