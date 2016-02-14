package com.eagle.portal.web.main.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.eagle.user.domain.User;

@Entity
@Table(name = "seller", catalog = "eagle")
public class Seller extends User{

	private static final long serialVersionUID = 8045181204369817007L;

	@Column(name = "is_exporter")
    //@NotNull
	private Boolean isExporter;
	
	@Column(name = "is_auction_agent")
	private Boolean isAuctionAgent;
	
	@Column(name = "biz_type")
    @Size(max = 100)
	private String bizType;
	
	@Column(name = "is_supplier")
	private Boolean isSupplier;
	
	@Column(name = "is_distributor")
	private Boolean isDistributor;
	
	@Column(name = "is_deals_car")
	private Boolean isDealsCar;
	
	@Column(name = "is_deals_machinery")
	private Boolean isDealsMachinery;
	
	@Column(name = "is_deals_spare_parts")
	private Boolean isDealsSpareParts;
	
	@Column(name = "biz_name")
    @Size(max = 100)
	private String bizName;
	
	@Column(name = "biz_established_on")
    @Size(max = 100)
	private String bizEstablishedOn;
	
	@Column(name = "operational_country")
    @Size(max = 100)
	private String operationalCountry;
	
	@Column(name = "currency_id")
    @Size(max = 100)
	private String currencyId;
	
	@Column(name = "biz_reg_certificate_path")
    @Size(max = 100)
	private String bizRegCertificatePath;
	
	@Column(name = "biz_police_certificate_path")
    @Size(max = 100)
	private String bizPoliceCertificatePath;
	
	@Column(name = "biz_reg_card_path")
    @Size(max = 100)
	private String bizRegCardPath;
	
	@Column(name = "letter_of_card_accepted")
    @Size(max = 100)
	private String letterOfCardAccepted;
	
	@Column(name = "bank_transfer_accepted")
    @Size(max = 100)
	private String bankTransferAccepted;
	
	@Column(name = "about_company")
    @Size(max = 100)
	private String aboutCompany;
	
	@Column(name = "notify_logins")
    @Size(max = 100)
	private String notifyLogins;

	@ManyToOne
	@JoinColumn(name="biz_ContactInfo_id",unique=true)
	//@NotFound(action=NotFoundAction.IGNORE)
	private ContactInfo contactInfo;
	
	public Boolean getIsExporter() {
		return isExporter;
	}

	public void setIsExporter(Boolean isExporter) {
		this.isExporter = isExporter;
	}

	public Boolean getIsAuctionAgent() {
		return isAuctionAgent;
	}

	public void setIsAuctionAgent(Boolean isAuctionAgent) {
		this.isAuctionAgent = isAuctionAgent;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public Boolean getIsSupplier() {
		return isSupplier;
	}

	public void setIsSupplier(Boolean isSupplier) {
		this.isSupplier = isSupplier;
	}

	public Boolean getIsDistributor() {
		return isDistributor;
	}

	public void setIsDistributor(Boolean isDistributor) {
		this.isDistributor = isDistributor;
	}

	public Boolean getIsDealsCar() {
		return isDealsCar;
	}

	public void setIsDealsCar(Boolean isDealsCar) {
		this.isDealsCar = isDealsCar;
	}

	public Boolean getIsDealsMachinery() {
		return isDealsMachinery;
	}

	public void setIsDealsMachinery(Boolean isDealsMachinery) {
		this.isDealsMachinery = isDealsMachinery;
	}

	public Boolean getIsDealsSpareParts() {
		return isDealsSpareParts;
	}

	public void setIsDealsSpareParts(Boolean isDealsSpareParts) {
		this.isDealsSpareParts = isDealsSpareParts;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizEstablishedOn() {
		return bizEstablishedOn;
	}

	public void setBizEstablishedOn(String bizEstablishedOn) {
		this.bizEstablishedOn = bizEstablishedOn;
	}

	public String getOperationalCountry() {
		return operationalCountry;
	}

	public void setOperationalCountry(String operationalCountry) {
		this.operationalCountry = operationalCountry;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getBizRegCertificatePath() {
		return bizRegCertificatePath;
	}

	public void setBizRegCertificatePath(String bizRegCertificatePath) {
		this.bizRegCertificatePath = bizRegCertificatePath;
	}

	public String getBizPoliceCertificatePath() {
		return bizPoliceCertificatePath;
	}

	public void setBizPoliceCertificatePath(String bizPoliceCertificatePath) {
		this.bizPoliceCertificatePath = bizPoliceCertificatePath;
	}

	public String getBizRegCardPath() {
		return bizRegCardPath;
	}

	public void setBizRegCardPath(String bizRegCardPath) {
		this.bizRegCardPath = bizRegCardPath;
	}

	public String getLetterOfCardAccepted() {
		return letterOfCardAccepted;
	}

	public void setLetterOfCardAccepted(String letterOfCardAccepted) {
		this.letterOfCardAccepted = letterOfCardAccepted;
	}

	public String getBankTransferAccepted() {
		return bankTransferAccepted;
	}

	public void setBankTransferAccepted(String bankTransferAccepted) {
		this.bankTransferAccepted = bankTransferAccepted;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public String getNotifyLogins() {
		return notifyLogins;
	}

	public void setNotifyLogins(String notifyLogins) {
		this.notifyLogins = notifyLogins;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
}
