package com.hellochemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hellochemo.business.bean.EmployeeBean;
import com.hellochemo.entity.EmployeeEntity;
@Repository
@SuppressWarnings("unchecked")
@Transactional(value="txManager")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		
		EmployeeEntity employeeEntityBean =convertBeanToEntity(employeeBean);
		try {
		
			
				entityManager.persist(employeeEntityBean);
				
			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}
		return employeeID;
	}
	
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;
		
		try {
		
			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);

			if(employeeEntity!=null){
				employeeBean=convertEntityToBean(employeeEntity);
			}
			
		} catch (Exception exception) {

			throw exception;
		}
		
		return employeeBean;
	}
	
	
	
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean2 = null;
		
		try {
		
			EmployeeEntity employeeEntityBean2 = (EmployeeEntity) entityManager.find(EmployeeEntity.class, employeeBean.getId());
			if(employeeEntityBean2 != null)
			
			{	
					employeeEntityBean2.setInsertTime(employeeBean.getInsertTime());
					employeeEntityBean2.setName(employeeBean.getName());
					employeeEntityBean2.setRole(employeeBean.getRole());
					employeeEntityBean2.setSalary(employeeBean.getSalary());
		
					employeeBean2 = convertEntityToBean(employeeEntityBean2);
				
			}
			
		} catch (Exception exception) {

			throw exception;
		}
		return employeeBean2;
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception{
		EmployeeBean employeeBean = null;
		try {
		
			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);
			if(employeeEntity != null)
			
			{	
					entityManager.remove(employeeEntity);
				
				employeeBean =convertEntityToBean(employeeEntity);
			}			

		} catch (Exception exception) {

			throw exception;
		}
		

		return employeeBean;
	}
	
	
	public List<EmployeeBean> getEmployeeList() throws Exception{
		// TODO Auto-generated method stub
		List<EmployeeBean> listEmployeeBean = null;
		
		try {
		
			listEmployeeBean=new ArrayList<EmployeeBean>();
			List<EmployeeEntity> listEmployeeEntity= (List<EmployeeEntity>) entityManager.createQuery("from EmployeeEntity").getResultList();

			for (EmployeeEntity entity:listEmployeeEntity){
				EmployeeBean emp= convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}
			

		} catch (Exception exception) {
			throw exception;
		}
		
		//return employeeEntityBean2;
		return (listEmployeeBean);
	}
	
	public static EmployeeBean convertEntityToBean(EmployeeEntity entity){
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static EmployeeEntity convertBeanToEntity(EmployeeBean bean){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean,employeeEntityBean);
		return employeeEntityBean;
	}
	
	
}
