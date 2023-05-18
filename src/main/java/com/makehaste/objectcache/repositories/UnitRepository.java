package com.makehaste.objectcache.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.makehaste.objectcache.entity.Unit;

public interface UnitRepository extends CrudRepository<Unit, String> {
	
	Optional<Unit> findById(String unitName);
}
