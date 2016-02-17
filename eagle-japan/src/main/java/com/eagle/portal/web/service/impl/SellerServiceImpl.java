package com.eagle.portal.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.impl.GenericServiceImpl;
import com.eagle.portal.web.dao.ContactInfoDao;
import com.eagle.portal.web.dao.CountryDao;
import com.eagle.portal.web.dao.SellerDao;
import com.eagle.portal.web.domain.ContactInfo;
import com.eagle.portal.web.domain.Country;
import com.eagle.portal.web.domain.Seller;
import com.eagle.portal.web.service.SellerService;
import com.eagle.user.dao.RolePermissionDao;
import com.eagle.user.domain.Permission;
import com.eagle.user.domain.Role;
import com.eagle.user.domain.RolePermission;
import com.eagle.user.domain.UserPermission;
import com.eagle.user.domain.UserRole;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class SellerServiceImpl extends GenericServiceImpl<Seller>implements SellerService {
	
	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private ContactInfoDao contactInfoDao;
	
	@Autowired
	private RolePermissionDao rolePermissionDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	void init() {
		init(Seller.class, sellerDao);
	}

	@Override
	@Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
	public Seller save(Seller obj) throws ServiceException {

		if (obj != null) {
			if (obj.getId() == null) {
				this.add(obj);
			} else {
				this.edit(obj);
			}
		} else {
			throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
		}
		return obj;
	}

	public Seller add(Seller seller) throws ServiceException {
        validateConstraints(seller);

        try {
        	//encode password
        	seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        	
        	//set user_role
        	Role role = new Role();
        	role.setId(2);//seller's role_id -> 2
        	
        	UserRole userRole = new UserRole();
        	userRole.setRole(role);
        	userRole.setUser(seller);
        	
        	seller.getRoleList().add(userRole);
        	
        	//set user_permission
        	List<RolePermission> rolePermissions = rolePermissionDao.getByRoleId(2);
        	for(RolePermission rolePermission : rolePermissions){
        		Permission permission = rolePermission.getPermission();
        		
        		UserPermission userPermission = new UserPermission();
        		userPermission.setPermission(permission);
        		userPermission.setUser(seller);
        		
        		seller.getPermissionList().add(userPermission);
        	}
        	
        	sellerDao.add(seller);
        	
        	//reset 2nd level references
        	seller.setRoleList(new ArrayList<UserRole>());
        	seller.setPermissionList(new ArrayList<UserPermission>());
            
            return seller;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

	public Seller edit(Seller seller) throws ServiceException {

		try {
			ContactInfo contactInfo = seller.getContactInfo();
			Country country = contactInfo.getCountry();
			
			countryDao.add(country);
			contactInfoDao.add(contactInfo);
			sellerDao.modify(seller);
			
			//reset 2nd level references
        	seller.setRoleList(new ArrayList<UserRole>());
        	seller.setPermissionList(new ArrayList<UserPermission>());
        	seller.setContactInfo(new ContactInfo());
			
			return seller;
		} catch (DataAccessException e) {
			throw translateException(e);
		}
	}
}
