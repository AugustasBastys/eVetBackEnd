/**
 * @(#) AvaliableOptions.java
 */

package com.vgtu.evet.entities.vetServices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "available_times")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AvailableTime
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotNull
	private Date date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "veterinarian_id", referencedColumnName = "id")
	@NotNull
	private Veterinarian veterinarian;

	@Column
	private boolean booked;

}
