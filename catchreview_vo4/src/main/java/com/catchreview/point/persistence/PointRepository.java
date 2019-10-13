package com.catchreview.point.persistence;

import org.springframework.data.repository.CrudRepository;

import com.catchreview.point.domain.Point;

public interface PointRepository extends CrudRepository<Point, Long>{

}
