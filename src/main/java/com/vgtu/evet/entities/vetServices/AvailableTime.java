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

@Entity
@Table(name = "available_time")
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
	private Date date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

}
