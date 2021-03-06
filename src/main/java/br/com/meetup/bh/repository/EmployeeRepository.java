package br.com.meetup.bh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.meetup.bh.entity.Employee;

@RepositoryRestResource/*(collectionResourceRel = "meetup", path = "meetup")*/
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
