package com.models;

import javax.persistence.*;

@Entity
@Table(name = "lora")
public class Lora {

    public Lora(Lora lora) {
        this.type =  lora.getType();
        this.status =  lora.getStatus();
        this.serial_number =  lora.getSerial_number();
        this.number = lora.getNumber();
        this.lot_id =  lora.getLot_id();
    }

    public Lora() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int type;
	private int status;
	private int serial_number;
	private int number;
	private int lot_id;
	private int created_at;
	private int updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLot_id() {
		return lot_id;
	}

	public void setLot_id(int lot_id) {
		this.lot_id = lot_id;
	}

	public int getCreated_at() {
		return created_at;
	}

	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}

	public int getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(int updated_at) {
		this.updated_at = updated_at;
	}
}
