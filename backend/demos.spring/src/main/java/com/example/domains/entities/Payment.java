package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.example.domains.core.entities.EntityBase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment extends EntityBase<Payment> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;

	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 5, fraction = 2)
	private BigDecimal amount;

	@Column(name="last_update")
	@Generated(value = GenerationTime.ALWAYS)
	private Timestamp lastUpdate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_date")
	private Date paymentDate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@NotNull
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Rental
	@ManyToOne
	@NotNull
	@JoinColumn(name="rental_id")
	private Rental rental;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@NotNull
	@JoinColumn(name="staff_id")
	private Staff staff;

	public Payment() {
	}
	
	public Payment(int paymentId) {
		super();
		this.paymentId = paymentId;
	}
	
	

	public Payment(int paymentId, Customer customer, @Valid Rental rental) {
		super();
		this.paymentId = paymentId;
		this.customer = customer;
		this.rental = rental;
	}

	public Payment(int paymentId, BigDecimal amount, @PastOrPresent Timestamp lastUpdate, Date paymentDate,
			Customer customer, @Valid Rental rental, Staff staff) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.lastUpdate = lastUpdate;
		this.paymentDate = paymentDate;
		this.customer = customer;
		this.rental = rental;
		this.staff = staff;
	}

	public Payment(int paymentId,
			@NotNull @DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 5, fraction = 2) BigDecimal amount,
			@PastOrPresent @NotNull Date paymentDate, @NotNull Staff staff, @NotNull Rental rental ) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.staff = staff;
		this.rental = rental;
		
		if(rental != null) {
			this.customer = rental.getCustomer();
		}
		
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Rental getRental() {
		return this.rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Payment))
			return false;
		Payment other = (Payment) obj;
		return paymentId == other.paymentId;
	}
	
}