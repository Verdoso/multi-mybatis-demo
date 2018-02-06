package org.greeneyed.multimybatisdemo.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnotherMapper {
	@Select("SELECT DATABASE() || ' ' || DATABASE_VERSION() FROM (VALUES(0))")
	String getVersion();
}
