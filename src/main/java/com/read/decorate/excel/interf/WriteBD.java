package com.read.decorate.excel.interf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface WriteBD  extends Serializable{
 
	
	/**
	 * Guardamos en bd tdoos los registros leidos de excel
	 * @param rowFound
	 * @param manager
	 */
	void createRecords( EntityManager manager)throws Exception;
}
