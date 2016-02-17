package com.eagle.portal.web.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.eagle.portal.web.domain.Seller;
import com.eagle.portal.web.domain.VehicleModel;

import java.util.Date;

/**
 * Vehicle Entity class
 */
@Entity
public class VehicleDto {

    @Id
    private Integer id;

    @Column(name = "body_type")
    private String bodyType;

    private String grade;

    private String transmission;

    @Column(name = "drive_type")
    private String driveType;

    private String steering;

    private String fuel;

    @Column(name = "manuf_year")
    private Integer manufactYear;

    @Column(name = "manuf_month")
    private Integer manufactMonth;

    @Column(name = "registration_date")
    private Date registrationDate;

    private Integer mileage;

    private String displacement;

    private float price;

    @Column(name = "stock_no")
    private String stockNo;

    @Column(name = "stock_location")
    private String stockLocation;

    @Column(name = "vin_chassis_no")
    private String vinChassisNo;

    @Column(name = "is_left_drive")
    private Boolean isLeftDrive;

    private String doors;

    @Column(name = "interior_color")
    private String interiorColor;

    @Column(name = "exterior_color")
    private String exteriorColor;

    private String keys;

    private String comments;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "fob_price")
    private float fobPrice;

    @Column(name = "in_stock")
    private Boolean inStock;
    
    @ManyToOne
	@JoinColumn(name="model_id")
	@NotFound(action=NotFoundAction.EXCEPTION)
    private VehicleModel vehicleModel;
    
    @ManyToOne
	@JoinColumn(name="seller_id")
	@NotFound(action=NotFoundAction.EXCEPTION)
    private Seller seller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getManufactYear() {
        return manufactYear;
    }

    public void setManufactYear(Integer manufactYear) {
        this.manufactYear = manufactYear;
    }

    public Integer getManufactMonth() {
        return manufactMonth;
    }

    public void setManufactMonth(Integer manufactMonth) {
        this.manufactMonth = manufactMonth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

    public String getVinChassisNo() {
        return vinChassisNo;
    }

    public void setVinChassisNo(String vinChassisNo) {
        this.vinChassisNo = vinChassisNo;
    }

    public Boolean getIsLeftDrive() {
        return isLeftDrive;
    }

    public void setIsLeftDrive(Boolean leftDrive) {
        isLeftDrive = leftDrive;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public float getFobPrice() {
        return fobPrice;
    }

    public void setFobPrice(float fobPrice) {
        this.fobPrice = fobPrice;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
    
}
