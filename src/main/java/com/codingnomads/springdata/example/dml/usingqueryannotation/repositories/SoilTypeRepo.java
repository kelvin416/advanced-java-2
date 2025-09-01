/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation.repositories;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query(value = "SELECT st FROM SoilType st ORDER BY st.ph DESC")
    List<SoilType> findAllOrderByPhDesc();

    @Query("SELECT st FROM SoilType st WHERE st.name = ?1")
    List<SoilType> findByName();

    @Query("SELECT st FROM SoilType st WHERE st.ph > ?1")
    List<SoilType> findByPhGreaterThan(double ph);

    @Query("SELECT st FROM SoilType st WHERE st.dry = :dry")
    List<SoilType> getSoilTypeBasedOnDry(@Param("dry") boolean dry);
}
