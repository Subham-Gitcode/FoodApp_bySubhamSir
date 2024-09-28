package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.Branch;

public class BrachDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();

	public Branch createBranch(Branch b) {
		// TODO Auto-generated method stub
		et.begin();
		Branch b1=em.merge(b);
		et.commit();
		return b1;

	}
	
	public Branch findBranchById(int branchId)
	{
		return em.find(Branch.class, branchId);
	}

	public void deleteBranch(Branch branch) {
		// TODO Auto-generated method stub
		et.begin();
		em.remove(branch);
		et.commit();
	}
	
	public List<Branch> findAllBranch()
	{
		return em.createQuery("select b from Branch b where status=false").getResultList();
	}

}
