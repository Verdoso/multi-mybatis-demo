package org.greeneyed.multimybatisdemo.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OneMapper {
	@Select("SELECT DATABASE() || ' ' || H2VERSION() FROM DUAL")
	String getVersion();
}
