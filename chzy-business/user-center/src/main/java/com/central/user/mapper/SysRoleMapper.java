package com.central.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author ligy7
 * 角色
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

    List<SysRole> findRolesByUserId(Long id);
}
