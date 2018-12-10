package com.spring.learning.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
/*
 * 
 * postgres=# select * from doctor;
    doctortye    | doctorid |     doctorname     | doessurgery | givesadvice 
-----------------+----------+--------------------+-------------+-------------
 Doctor          |        1 | Dr. Arsad          |             | 
 Surgeon         |        2 | Dr. Lohia          | t           | 
 FamilyPhysician |        3 | Dr. Kartavya Shaah |             | t
(3 rows)

 */
@Inheritance(strategy=InheritanceType.JOINED)

/*
 * postgres=# select * from doctor;
    doctortye    | doctorid |     doctorname     
-----------------+----------+--------------------
 Doctor          |        1 | Dr. Arsad
 Surgeon         |        2 | Dr. Lohia
 FamilyPhysician |        3 | Dr. Kartavya Shaah
(3 rows)

postgres=# 
postgres=# 
postgres=# 
postgres=# select * from surgeon;
 doessurgery | doctorid 
-------------+----------
 t           |        2
(1 row)

postgres=# select * from familyphysician ;
 givesadvice | doctorid 
-------------+----------
 t           |        3
(1 row)

postgres=# 

 */
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="DoctorTye")
public class Doctor {

	@Id
	@GeneratedValue
	private Integer doctorId;
	private String doctorName;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

}
