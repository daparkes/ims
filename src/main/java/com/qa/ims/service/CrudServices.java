/**
 * Interface defining the CrudServices class.
 */
package com.qa.ims.service;

import java.util.List;

public interface CrudServices<T> {

    public List<T> readAll();
     
    T create(T t);
     
    T update(T t);
 
    void delete(Long id);

}
