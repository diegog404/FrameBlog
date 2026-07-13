package com.aluno.FrameBlog.services.v2;

import java.util.List;

import com.aluno.FrameBlog.models.v2.AddressV2;

public interface AddressServiceV2 {

	AddressV2 save(AddressV2 addressV2);

	List<AddressV2> getAll();

	AddressV2 update(Long id, AddressV2 addressV2);

	void delete(Long id);

	AddressV2 get(Long id);
}
