package com.team6.internetPortal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.internetPortal.entity.Video;
public interface IVideoRepository extends JpaRepository<Video,Long> {

//	public List<Video> findAllVideoByCategory(int id);

	@Query(value = "SELECT * FROM video v WHERE v.category_id  = ?1 ", nativeQuery = true)
	public List<Video> findbyCategory_Id(int id);
	
	@Query(value = "SELECT * FROM video v WHERE v.creator_id  = :id ", nativeQuery = true)
	public List<Video> findbyCreator_Id(@Param("id")int id);

	@Query(value = "SELECT * FROM video v join subscription s on v.category_id  = s.category_id where s.subscriber_id=:id ", nativeQuery = true)
	public List<Video> findbySubscription(int id);

	
	
	


}
