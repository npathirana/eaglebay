package com.eagle.commons.util;

import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eagle.portal.web.domain.Seller;
import com.eagle.portal.web.dto.SellerDto;

/**
 * 
 * @author Tharanga
 *
 */
public class DtoConverter {
	
	private static final Logger logger = LoggerFactory.getLogger(DtoConverter.class);
	
	/**
	 * convert Dto objects to Entity objects
	 * @param dto
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	public static <D,E> E convertToEntity(D dto,E entity){
		
		for(Field dtoField : dto.getClass().getDeclaredFields()){
			
			try {
				Field entityField = entity.getClass().getDeclaredField(dtoField.getName());
				
				dtoField.setAccessible(true);
				entityField.setAccessible(true);
				entityField.set(entity, dtoField.get(dtoField));
				
			} catch (NoSuchFieldException e) {
				logger.error("convertToEntity : {}",e);
				continue;
			} catch (IllegalArgumentException e) {
				logger.error("convertToEntity : {}",e);
			} catch (IllegalAccessException e) {
				logger.error("convertToEntity : {}",e);
			} 
			
		}
		
		return entity;
	}
}
