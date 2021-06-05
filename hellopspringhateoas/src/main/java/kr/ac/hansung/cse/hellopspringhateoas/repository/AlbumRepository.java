package kr.ac.hansung.cse.hellopspringhateoas.repository;

import kr.ac.hansung.cse.hellopspringhateoas.entity.AlbumEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumRepository extends PagingAndSortingRepository<AlbumEntity, Long> {

}