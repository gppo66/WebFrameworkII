package kr.ac.hansung.cse.hellopspringhateoas.repository;

import kr.ac.hansung.cse.hellopspringhateoas.entity.ActorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActorRepository extends PagingAndSortingRepository<ActorEntity, Long> {

}